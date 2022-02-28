var swiper =  new Swiper(".mainslider", {
    // autoplay: {
    // delay: 6000,
    // disableOnInteraction: false,
    // },
    slidesPerView: 1,
    loop: true,
    speed: 500,
    effect: "fade",
    fadeEffect: {
        crossFade: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

var swiper =  new Swiper(".carousel", {
    // autoplay: {
    //     delay: 5000,
    //     disableOnInteraction: false,
    //     },
    loop:false,
    slidesPerView: 1,
    spaceBetween: 30,
    navigation: {
        clickable: true,
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    breakpoints: {
        768: {
            slidesPerView: 2,
            spaceBetween: 30,
        },
        1024: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
        1300: {
            slidesPerView: 4,
            spaceBetween: 30,
        },
    },
});

var swiper =  new Swiper(".carousel-overflow", {
    // autoplay: {
    //     delay: 5000,
    //     disableOnInteraction: false,
    //     },
    slidesPerView: 1,
    spaceBetween: 30,
    loop: true,
    navigation: {
        clickable: true,
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    breakpoints: {
        768: {
            slidesPerView: 2,
            spaceBetween: 30,
        },
        1024: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
        1300: {
            slidesPerView: 4,
            spaceBetween: 30,
        },
    },
});

var swiper =  new Swiper(".carousel2", {
    // autoplay: {
    //     delay: 5000,
    //     disableOnInteraction: false,
    //     },
    slidesPerView: 1,
    loop: false, 
    spaceBetween: 30,
    navigation: {
        clickable: true,
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },

    breakpoints: {
        768: {
            slidesPerView: 2,
            spaceBetween: 30,
        },
        1024: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
    },
});

var swiper =  new Swiper(".carousel3", {
    // autoplay: {
    //     delay: 5000,
    //     disableOnInteraction: false,
    //     },
    slidesPerView: 1,
    loop: false, 
    spaceBetween: 30,
    breakpoints: {
        768: {
            slidesPerView: 2,
            spaceBetween: 30,
        },
        1024: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
    },
});

var swiper =  new Swiper(".seller-slider", {
    slidesPerView: 2,
    loop: false, 
    spaceBetween: 30,
    navigation: {
        clickable: true,
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    grabCursor: true,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    breakpoints: {
        500: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
        640: {
            slidesPerView: 4,
            spaceBetween: 30,
        },
        768: {
            slidesPerView: 5,
            spaceBetween: 30,
        },
        1070: {
            slidesPerView: 7,
            spaceBetween: 30,
        },
        1400: {
            slidesPerView: 9,
            spaceBetween: 30,
        }
    },
});

var swiper =  new Swiper(".seller-slider2", {
    slidesPerView: 2,
    loop: false, 
    spaceBetween: 30,
    navigation: {
        clickable: true,
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    grabCursor: true,
    breakpoints: {
        500: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
        640: {
            slidesPerView: 4,
            spaceBetween: 30,
        },
        768: {
            slidesPerView: 5,
            spaceBetween: 30,
        },
        1070: {
            slidesPerView: 7,
            spaceBetween: 30,
        },
        1400: {
            slidesPerView: 9,
            spaceBetween: 30,
        }
    },
});

var swiper =  new Swiper(".carousel4", {
    // autoplay: {
    //     delay: 5000,
    //     disableOnInteraction: false,
    //     },
    slidesPerView: 1,
    loop: false, 
    spaceBetween: 30,
    breakpoints: {
        768: {
            slidesPerView: 2,
            spaceBetween: 30,
        },
        1024: {
            slidesPerView: 3,
            spaceBetween: 30,
        },
    },
});