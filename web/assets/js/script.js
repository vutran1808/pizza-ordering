const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

// Load header and footer

function load(selector, path) {
    const cached = localStorage.getItem(path);
    if (cached) {
        $(selector).innerHTML = cached;
    }

    fetch(path)
        .then((res) => res.text())
        .then((html) => {
            if (html !== cached) {
                $(selector).innerHTML = html;
                localStorage.setItem(path, html);
            }
        })
        .finally(() => {
            window.dispatchEvent(new Event("template-loaded"));
        });
}

// Toggle Js

window.addEventListener('template-loaded', initJsToggle);

function initJsToggle(e) {
    e.preventDefault();
    $$('.js-toggle').forEach(item => {
        const target = item.getAttribute('toggle-target');

        if(!target) {
            document.body.innerText = 'Missing toggle Target!';
        }

        item.addEventListener('click', () => {
            if(!$(target)) {
                return;
            }
            const isHidden = $(target).classList.contains('hide');
            requestAnimationFrame(() => {
                $(target).classList.toggle('hide', !isHidden);
                $(target).classList.toggle('show', isHidden);
            })
        });

        document.onclick = (e) => {
            if(!e.target.closest(target)) {
                const isHidden = $(target).classList.contains("hide");
                if(!isHidden) {
                    item.click();
                }
            }
        }
    })
}

window.addEventListener('template-loaded', activeNavbarLink);

function activeNavbarLink() {
    const liElements = $$('.navbar__list .navbar__item:not(:last-child) .navbar__link');
    if(!liElements) return;

    const activeLine = $('.navbar .navbar__line');
    const currentLocation = window.location.pathname.slice(window.location.pathname.lastIndexOf('/') + 1);
    [...liElements].forEach((item) => {
        if(item.getAttribute('href') === currentLocation){
            activeLine.style.width = item.offsetWidth - 32 + 'px';
            activeLine.style.left = item.offsetLeft + 16 + 'px';
        }
    })
}

window.addEventListener('template-loaded', handleShowFormModal);

const toggleOverlay = () => {
    const overlay = $('.overlay');
    const isHidden = overlay.classList.contains('hide');
    requestAnimationFrame(() => {
        overlay.classList.toggle('hide', !isHidden);
        overlay.classList.toggle('show', isHidden);
    })
};

const renderForm = (targetModal) => {
    const formContainer = $('.form__container');
    fetch(`./components/${targetModal}`)
        .then(res => res.text())
        .then(html => {
            formContainer.innerHTML = html;
            window.dispatchEvent(new Event('form-loaded'))
        })
}

function handleShowFormModal() {
    const dropDownItems = $$('.dropdown__item');
    const closeBtn = $('.form-close-btn');

    [...dropDownItems].forEach(item => {
        const targetModal = item.getAttribute('modal');
        if(!targetModal) return;
        item.addEventListener('click', () => {
            toggleOverlay();
            renderForm(targetModal);
        })
    });

    closeBtn.onclick = () => {
        toggleOverlay();
    }
}
window.addEventListener('form-loaded', () => {
    const formTexts = $$('.form__text--title');
    [...formTexts].forEach(item => {
        const targetModal = item.getAttribute('modal');
        if(!targetModal) return;
        item.addEventListener('click', () => {
            renderForm(targetModal);
        })
    });
})

window.addEventListener('template-loaded', activeMenuNavbar);
window.addEventListener('scroll', debounce(activeMenuList));

function debounce(func, timeout = 300) {
    let timers;
    return (...args) => {
        clearTimeout(timers);
        timers = setTimeout(() => { func() }, timeout);
    };
}

function activeMenuNavbar(target) {
    const currentTarget = '#' + target;
    const categoryItems = $$('.category__link');

    categoryItems.forEach(item => {
        item.classList.remove('active');
        if(item.getAttribute('href') === currentTarget){
            item.classList.add('active');
        }
    })
}

function isInViewport(element) {
    const rect = element.getBoundingClientRect();
    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

function activeMenuList() {
    const foodMenuItems = $$('.food__menu--item');

    foodMenuItems.forEach(item => {
        if(isInViewport(item)) {
            activeMenuNavbar(item.getAttribute('id'));
        }
    })
    
}



