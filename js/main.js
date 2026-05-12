/**
 * 北京千面科技有限公司 - 官网交互脚本
 */

document.addEventListener('DOMContentLoaded', function() {
    // 初始化
    initNavbar();
    initMobileMenu();
    initScrollAnimation();
    initSolutionsTabs();
    initContactForm();
    initParticles();
    initRevealAnimation();
});

/**
 * 导航栏交互
 */
function initNavbar() {
    const navbar = document.getElementById('navbar');
    const scrollIndicator = document.querySelector('.scroll-indicator');
    
    // 滚动监听
    window.addEventListener('scroll', function() {
        const scrollY = window.scrollY;
        
        // 导航栏背景
        if (scrollY > 50) {
            navbar.classList.add('scrolled');
        } else {
            navbar.classList.remove('scrolled');
        }
        
        // 滚动指示器隐藏
        if (scrollIndicator) {
            if (scrollY > 100) {
                scrollIndicator.style.opacity = '0';
                scrollIndicator.style.pointerEvents = 'none';
            } else {
                scrollIndicator.style.opacity = '1';
                scrollIndicator.style.pointerEvents = 'auto';
            }
        }
        
        // 导航链接高亮
        updateActiveNavLink();
    });
    
    // 点击导航链接平滑滚动
    document.querySelectorAll('.nav-links a, .mobile-menu a').forEach(function(link) {
        link.addEventListener('click', function(e) {
            const href = this.getAttribute('href');
            if (href.startsWith('#')) {
                e.preventDefault();
                const target = document.querySelector(href);
                if (target) {
                    const offsetTop = target.offsetTop - 80;
                    window.scrollTo({
                        top: offsetTop,
                        behavior: 'smooth'
                    });
                }
            }
            // 关闭移动端菜单
            const mobileMenu = document.getElementById('mobileMenu');
            if (mobileMenu) {
                mobileMenu.classList.remove('active');
            }
        });
    });
}

/**
 * 更新当前激活的导航链接
 */
function updateActiveNavLink() {
    const sections = document.querySelectorAll('section[id]');
    const navLinks = document.querySelectorAll('.nav-links a');
    
    let currentSection = '';
    
    sections.forEach(function(section) {
        const rect = section.getBoundingClientRect();
        if (rect.top <= 150 && rect.bottom >= 150) {
            currentSection = section.getAttribute('id');
        }
    });
    
    navLinks.forEach(function(link) {
        link.classList.remove('active');
        if (link.getAttribute('href') === '#' + currentSection) {
            link.classList.add('active');
        }
    });
}

/**
 * 移动端菜单
 */
function initMobileMenu() {
    const menuBtn = document.getElementById('mobileMenuBtn');
    const mobileMenu = document.getElementById('mobileMenu');
    
    if (menuBtn && mobileMenu) {
        menuBtn.addEventListener('click', function() {
            mobileMenu.classList.toggle('active');
            // 按钮动画
            const spans = menuBtn.querySelectorAll('span');
            if (mobileMenu.classList.contains('active')) {
                spans[0].style.transform = 'rotate(45deg) translate(5px, 5px)';
                spans[1].style.opacity = '0';
                spans[2].style.transform = 'rotate(-45deg) translate(5px, -5px)';
            } else {
                spans[0].style.transform = 'none';
                spans[1].style.opacity = '1';
                spans[2].style.transform = 'none';
            }
        });
    }
}

/**
 * 滚动动画
 */
function initScrollAnimation() {
    // 滚动手势
    const scrollIndicator = document.querySelector('.scroll-indicator');
    if (scrollIndicator) {
        scrollIndicator.addEventListener('click', function() {
            const nextSection = document.querySelector('#about');
            if (nextSection) {
                window.scrollTo({
                    top: nextSection.offsetTop - 80,
                    behavior: 'smooth'
                });
            }
        });
    }
}

/**
 * 解决方案标签页
 */
function initSolutionsTabs() {
    const tabBtns = document.querySelectorAll('.tab-btn');
    const panels = document.querySelectorAll('.solution-panel');
    
    tabBtns.forEach(function(btn) {
        btn.addEventListener('click', function() {
            const tab = this.getAttribute('data-tab');
            
            // 更新按钮状态
            tabBtns.forEach(function(b) {
                b.classList.remove('active');
            });
            this.classList.add('active');
            
            // 更新面板显示
            panels.forEach(function(panel) {
                panel.classList.remove('active');
                if (panel.id === tab) {
                    panel.classList.add('active');
                }
            });
        });
    });
}

/**
 * 联系表单
 */
function initContactForm() {
    const form = document.getElementById('contactForm');
    
    if (form) {
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            
            const formData = new FormData(form);
            const data = Object.fromEntries(formData.entries());
            
            // 表单验证
            if (!data.name || !data.email || !data.message) {
                showToast('请填写完整信息', 'error');
                return;
            }
            
            // 邮箱验证
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(data.email)) {
                showToast('请输入有效的邮箱地址', 'error');
                return;
            }
            
            // 模拟提交
            const submitBtn = form.querySelector('.btn');
            const originalText = submitBtn.textContent;
            submitBtn.textContent = '提交中...';
            submitBtn.disabled = true;
            
            setTimeout(function() {
                showToast('留言已收到，我们会尽快与您联系！', 'success');
                form.reset();
                submitBtn.textContent = originalText;
                submitBtn.disabled = false;
            }, 1500);
        });
    }
}

/**
 * 提示信息
 */
function showToast(message, type) {
    // 创建提示元素
    const toast = document.createElement('div');
    toast.className = 'toast toast-' + type;
    toast.innerHTML = '<span>' + message + '</span>';
    
    // 添加样式
    Object.assign(toast.style, {
        position: 'fixed',
        top: '100px',
        left: '50%',
        transform: 'translateX(-50%)',
        padding: '16px 24px',
        background: type === 'success' ? '#10b981' : '#ef4444',
        color: '#fff',
        borderRadius: '8px',
        fontSize: '15px',
        zIndex: '9999',
        opacity: '0',
        transition: 'opacity 0.3s ease',
        boxShadow: '0 4px 12px rgba(0,0,0,0.15)'
    });
    
    document.body.appendChild(toast);
    
    // 显示
    setTimeout(function() {
        toast.style.opacity = '1';
    }, 10);
    
    // 隐藏
    setTimeout(function() {
        toast.style.opacity = '0';
        setTimeout(function() {
            document.body.removeChild(toast);
        }, 300);
    }, 3000);
}

/**
 * 粒子效果
 */
function initParticles() {
    const container = document.getElementById('particles');
    if (!container) return;
    
    const particleCount = 30;
    
    for (let i = 0; i < particleCount; i++) {
        const particle = document.createElement('div');
        particle.className = 'particle';
        
        // 随机位置
        const x = Math.random() * 100;
        const y = Math.random() * 100;
        
        // 随机大小
        const size = Math.random() * 6 + 2;
        
        // 随机动画延迟
        const delay = Math.random() * 5;
        const duration = Math.random() * 10 + 10;
        
        Object.assign(particle.style, {
            position: 'absolute',
            left: x + '%',
            top: y + '%',
            width: size + 'px',
            height: size + 'px',
            background: Math.random() > 0.5 ? 'rgba(0, 102, 255, 0.3)' : 'rgba(0, 204, 170, 0.3)',
            borderRadius: '50%',
            animation: 'floatParticle ' + duration + 's ease-in-out ' + delay + 's infinite'
        });
        
        container.appendChild(particle);
    }
    
    // 添加动画样式
    const style = document.createElement('style');
    style.textContent = `
        @keyframes floatParticle {
            0%, 100% { transform: translate(0, 0); opacity: 0; }
            25% { opacity: 1; }
            50% { transform: translate(30px, -30px); opacity: 0.5; }
            75% { opacity: 1; }
            100% { transform: translate(0, 0); opacity: 0; }
        }
    `;
    document.head.appendChild(style);
}

/**
 * 滚动reveal动画
 */
function initRevealAnimation() {
    const reveals = document.querySelectorAll('.service-card, .value-card, .solution-panel, .info-item');
    
    const observer = new IntersectionObserver(function(entries) {
        entries.forEach(function(entry) {
            if (entry.isIntersecting) {
                entry.target.classList.add('active');
            }
        });
    }, {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    });
    
    reveals.forEach(function(el) {
        el.classList.add('reveal');
        observer.observe(el);
    });
    
    // 初始检查
    setTimeout(function() {
        reveals.forEach(function(el) {
            const rect = el.getBoundingClientRect();
            if (rect.top < window.innerHeight) {
                el.classList.add('active');
            }
        });
    }, 100);
}

/**
 * 防抖函数
 */
function debounce(func, wait) {
    let timeout;
    return function() {
        const context = this;
        const args = arguments;
        clearTimeout(timeout);
        timeout = setTimeout(function() {
            func.apply(context, args);
        }, wait);
    };
}

/**
 * 节流函数
 */
function throttle(func, limit) {
    let inThrottle;
    return function() {
        const context = this;
        const args = arguments;
        if (!inThrottle) {
            func.apply(context, args);
            inThrottle = true;
            setTimeout(function() {
                inThrottle = false;
            }, limit);
        }
    };
}