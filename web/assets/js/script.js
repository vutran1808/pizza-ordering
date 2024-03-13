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

        if (!target) {
            document.body.innerText = 'Missing toggle Target!';
        }

        item.addEventListener('click', () => {
            if (!$(target)) {
                return;
            }
            const isHidden = $(target).classList.contains('hide');
            requestAnimationFrame(() => {
                $(target).classList.toggle('hide', !isHidden);
                $(target).classList.toggle('show', isHidden);
            })
        });

        document.onclick = (e) => {
            if (!e.target.closest(target)) {
                const isHidden = $(target).classList.contains("hide");
                if (!isHidden) {
                    item.click();
                }
            }
        }
    })
}

window.addEventListener('template-loaded', activeNavbarLink);

function activeNavbarLink() {
    const liElements = $$('.navbar__list .navbar__item:not(:last-child) .navbar__link');
    if (!liElements) return;

    const activeLine = $('.navbar .navbar__line');
    const currentLocation = window.location.pathname.slice(window.location.pathname.lastIndexOf('/') + 1);
    [...liElements].forEach((item) => {
        if (item.getAttribute('href') === currentLocation) {
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
        if (!targetModal) return;
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
        if (!targetModal) return;
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
        if (item.getAttribute('href') === currentTarget) {
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
        if (isInViewport(item)) {
            activeMenuNavbar(item.getAttribute('id'));
        }
    })
}

window.addEventListener('template-loaded', handleShopCart)
window.addEventListener('template-loaded', setEmptyCart);

function handleShopCart() {
    const foodItems = $$('.food__list .food__item');
    foodItems.forEach(item => {
        const addBtn = item.querySelector('.add-to-card__btn');
        addBtn.onclick = (e) => {
            const foodId = item.querySelector('.food__card').getAttribute('food-id')
            const foodTitle = item.querySelector('.food__title').innerText;
            const foodPrice = item.querySelector('.food__price--value').innerText;
            const foodObj = { foodId, foodTitle, foodPrice }
            addToCart(foodObj);
        }
    })
}

function setEmptyCart() {
    const orderCart = $('.order-cart');
    const orderContent = orderCart.querySelector('.order-cart__content');
    const orderDetail = orderCart.querySelector('.order__detail');
    const isEmpty = orderDetail.childElementCount > 0;
    orderContent.classList.toggle('empty', !isEmpty);
    window.dispatchEvent(new Event('orderCart-loaded'));
}

function addToCart(item) {
    const { foodId, foodTitle, foodPrice } = item;
    const orderDetail = $('.order-cart .order__detail');
    const liElements = orderDetail.querySelectorAll('.order__detail--item');
    const liContent = ` <input type="hidden" name="food_id" value=${foodId} />
                        <input type="hidden" class="input-food__quantity" name="food_quantity" value="1"/>
                        <div class="order__desc">
                            <p class="order__food--title"><span class="food_quantity">1</span> x ${foodTitle}</p>
                        </div>
                        <div class="order__adjust">
                            <span class="order__detail--price">$<span class="food__price--value" price=${foodPrice} >${foodPrice}</span>.00</span>
                            <div class="order__adjust--btn">
                                <button class="adjust__btn" value="-">-</button>
                                <button class="adjust__btn" value="+">+</button>
                            </div>
                        </div>`;
    const li = document.createElement("li");
    li.setAttribute("id", foodId);
    li.className = "order__detail--item";
    li.innerHTML = liContent;

    if (!liElements.length) {
        orderDetail.appendChild(li);
        calTotal();
        return setEmptyCart();
    } 

    const dulicated = Array.from(liElements).filter(item => item.getAttribute('id') === foodId);
    if(!dulicated.length) {
        orderDetail.appendChild(li);
        calTotal();
        return setEmptyCart(); 
    } else {
        const quantity = dulicated[0].querySelector('.food_quantity');
        const price = dulicated[0].querySelector('.food__price--value');
        const inputQuantity = dulicated[0].querySelector('.input-food__quantity');
        quantity.innerText = +quantity.innerText + 1;
        price.innerText = foodPrice * +quantity.innerText;
        inputQuantity.value = quantity.innerText;
        calTotal();
    }
}

window.addEventListener('orderCart-loaded', addJustQuantity);

function addJustQuantity() {
    const orderDetail = $('.order-cart .order__detail');
    const liElements = orderDetail.querySelectorAll('.order__detail--item');
    liElements.forEach(item => {
        const adjustBtn = item.querySelectorAll('.adjust__btn');
        adjustBtn.forEach(button => {
            button.onclick = (e) => {
                e.preventDefault();
                const price = item.querySelector('.food__price--value');
                const buttonValue = e.target.value;
                if(buttonValue === '+') {
                    const quantity = item.querySelector('.food_quantity');
                    const inputQuantity = item.querySelector('.input-food__quantity');
                    quantity.innerText = +quantity.innerText + 1;
                    price.innerText = +price.innerText + +price.getAttribute('price');
                    inputQuantity.value = quantity.innerText;
                    calTotal();
                }
                if(buttonValue === '-') {
                    const quantity = item.querySelector('.food_quantity');
                    const inputQuantity = item.querySelector('.input-food__quantity');
                    if(+quantity.innerText === 1) {
                        item.remove();
                        setEmptyCart();
                    }
                    quantity.innerText = +quantity.innerText - 1;
                    price.innerText = +price.innerText - +price.getAttribute('price');
                    inputQuantity.value = quantity.innerText;
                    calTotal();
                }
            }
        })
    })
}

function calTotal() {
    const orderDetail = $('.order-cart .order__detail');
    const liElements = orderDetail.querySelectorAll('.order__detail--item');
    const totalPrice = $('.order-cart .order__cart--price-value');
    let sum = 0;
    liElements.forEach(item => {
        const liValue = item.querySelector('.food__price--value').innerText;
        sum += +liValue;
    })
    totalPrice.innerText = sum;
}

window.addEventListener('template-loaded', submitOrder);

function submitOrder() {
    const submitOrderBtn = $('.order-cart .order-cart__btn');
    submitOrderBtn.onclick = () => {
        const orderDetail = $('.order-cart .order-cart__notempty').innerHTML;
        localStorage.setItem("orderDetail", orderDetail);
    }
}

function loadOrderCart() {
    const checkOutOrderCart = $('.order-cart__notempty');
    checkOutOrderCart.innerHTML = localStorage.getItem("orderDetail");
    addJustQuantity();
}

function toggleAdminPage() {
    const sidebarItems = $$('.sidebar__item');
    console.log(sidebarItems);
    const content = $('.admin__content');
    sidebarItems.forEach(item => {
        item.onclick = () => {
            if(item.getAttribute('target') === 'task-list') {
                fetch('./order-task.html')
                .then((res) => res.text())
                .then((html) => {
                    content.innerHTML = html;
                })
            } 
            if(item.getAttribute('target') === 'menu-list') {
                fetch('./menu-list.html')
                .then((res) => res.text())
                .then((html) => {
                    content.innerHTML = html;
                })
            } 
        }
    })

}

function handleChangeFoodCard() {
    const liItems = $$('.order__list .order__list--item');
    liItems.forEach(item => {
        const updateBtn = item.querySelector('.update__btn');
        const removeBtn = item.querySelector('.remove__btn');
        updateBtn.onclick = () => {
        }
    })
}







