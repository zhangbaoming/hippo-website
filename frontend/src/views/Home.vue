<template>
  <div>
    <!-- Navigation -->
    <nav class="navbar" :class="{ scrolled: isScrolled }">
      <div class="container">
        <router-link to="/" class="logo">
          <span class="logo-icon">◆</span>
          <span class="logo-text">千面科技</span>
        </router-link>
        <ul class="nav-links">
          <li><router-link to="/">首页</router-link></li>
          <li><router-link to="/about">关于我们</router-link></li>
          <li><router-link to="/services">业务范围</router-link></li>
          <li><router-link to="/solutions">解决方案</router-link></li>
          <li><router-link to="/contact">联系我们</router-link></li>
        </ul>
        <button class="mobile-menu-btn" @click="showMobileMenu = !showMobileMenu">
          <span></span>
          <span></span>
          <span></span>
        </button>
      </div>
    </nav>

    <!-- Mobile Menu -->
    <div class="mobile-menu" :class="{ active: showMobileMenu }">
      <router-link to="/" @click="showMobileMenu = false">首页</router-link>
      <router-link to="/about" @click="showMobileMenu = false">关于我们</router-link>
      <router-link to="/services" @click="showMobileMenu = false">业务范围</router-link>
      <router-link to="/solutions" @click="showMobileMenu = false">解决方案</router-link>
      <router-link to="/contact" @click="showMobileMenu = false">联系我们</router-link>
    </div>

    <!-- Hero -->
    <section class="hero">
      <div class="hero-bg"></div>
      <div class="container">
        <div class="hero-content">
          <div class="hero-badge">AI · 大数据 · 云计算</div>
          <h1 class="hero-title">
            <span class="title-line">北京千面科技有限公司</span>
            <span class="title-sub">让科技更有温度</span>
          </h1>
          <p class="hero-desc">
            致力于人工智能技术的创新与应用，以大数据和云计算为核心，<br>
            为企业客户提供智能化解决方案，赋能数字化转型。<br>
            <span class="highlight">，助力企业腾飞，创造美好未来</span>
          </p>
          <div class="hero-stats">
            <div class="stat-item">
              <span class="stat-number">8+</span>
              <span class="stat-label">年行业经验</span>
            </div>
            <div class="stat-item">
              <span class="stat-number">100+</span>
              <span class="stat-label">企业客户</span>
            </div>
            <div class="stat-item">
              <span class="stat-number">50+</span>
              <span class="stat-label">解决方案</span>
            </div>
            <div class="stat-item">
              <span class="stat-number">98%</span>
              <span class="stat-label">客户满意度</span>
            </div>
          </div>
          <div class="hero-cta">
            <router-link to="/contact" class="btn btn-primary">联系我们</router-link>
            <router-link to="/services" class="btn btn-outline">了解更多</router-link>
          </div>
        </div>
        <div class="hero-visual">
          <div class="hero-graphic">
            <svg viewBox="0 0 400 400" class="hero-svg">
              <defs>
                <linearGradient id="grad1" x1="0%" y1="0%" x2="100%" y2="100%">
                  <stop offset="0%" style="stop-color:#0066ff;stop-opacity:0.8" />
                  <stop offset="100%" style="stop-color:#00ccaa;stop-opacity:0.8" />
                </linearGradient>
                <linearGradient id="grad2" x1="0%" y1="0%" x2="100%" y2="0%">
                  <stop offset="0%" style="stop-color:#0066ff" />
                  <stop offset="100%" style="stop-color:#00ccaa" />
                </linearGradient>
              </defs>
              <rect x="60" y="60" width="280" height="280" rx="20" fill="url(#grad1)" opacity="0.1"/>
              <rect x="80" y="80" width="240" height="240" rx="16" fill="white" opacity="0.9"/>
              <circle cx="200" cy="180" r="50" fill="url(#grad2)" opacity="0.2"/>
              <text x="200" y="175" text-anchor="middle" fill="#0066ff" font-size="36" font-weight="bold">千面</text>
              <text x="200" y="210" text-anchor="middle" fill="#00ccaa" font-size="20" font-weight="500">科技</text>
              <rect x="100" y="250" width="200" height="8" rx="4" fill="#0066ff" opacity="0.3"/>
              <rect x="100" y="270" width="160" height="8" rx="4" fill="#00ccaa" opacity="0.3"/>
              <rect x="100" y="290" width="180" height="8" rx="4" fill="#0066ff" opacity="0.3"/>
              <circle cx="320" cy="100" r="30" fill="#0066ff" opacity="0.1">
                <animate attributeName="r" values="30;35;30" dur="2s" repeatCount="indefinite"/>
              </circle>
              <circle cx="80" cy="300" r="20" fill="#00ccaa" opacity="0.1">
                <animate attributeName="r" values="20;25;20" dur="2.5s" repeatCount="indefinite"/>
              </circle>
              <circle cx="350" cy="250" r="15" fill="#0066ff" opacity="0.15">
                <animate attributeName="r" values="15;20;15" dur="3s" repeatCount="indefinite"/>
              </circle>
            </svg>
          </div>
        </div>
      </div>
    </section>

    <!-- Partners -->
    <section class="partners">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">合作伙伴</span>
          <h2 class="section-title">与我们同行的伙伴</h2>
        </div>
        <div class="partners-grid">
          <div class="partner-logo" v-for="partner in partners" :key="partner.id">
            {{ partner.name }}
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <div class="footer-content">
          <div class="footer-brand">
            <router-link to="/" class="logo">
              <span class="logo-icon">◆</span>
              <span class="logo-text">千面科技</span>
            </router-link>
            <p>让科技更有温度</p>
          </div>
          <div class="footer-links">
            <div class="footer-column">
              <h4>导航</h4>
              <router-link to="/">首页</router-link>
              <router-link to="/about">关于我们</router-link>
              <router-link to="/services">业务范围</router-link>
              <router-link to="/solutions">解决方案</router-link>
            </div>
            <div class="footer-column">
              <h4>服务</h4>
              <router-link to="/services">人工智能</router-link>
              <router-link to="/services">大数据</router-link>
              <router-link to="/services">云计算</router-link>
              <router-link to="/services">软件开发</router-link>
            </div>
            <div class="footer-column">
              <h4>联系方式</h4>
              <p>北京市海淀区中关村科技园</p>
              <p>contact@qianmian-tech.com</p>
              <p>010-12345678</p>
            </div>
          </div>
        </div>
        <div class="footer-bottom">
          <p>© 2024 北京千面科技有限公司 版权所有</p>
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import { getPartners } from '@/api'

const isScrolled = ref(false)
const showMobileMenu = ref(false)

const partners = ref([])

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

onMounted(async () => {
  window.addEventListener('scroll', handleScroll)
  try {
    const res = await getPartners()
    partners.value = res.data || []
  } catch (e) {
    partners.value = [
      { id: 1, name: '阿里巴巴' },
      { id: 2, name: '腾讯' },
      { id: 3, name: '百度' },
      { id: 4, name: '华为' },
      { id: 5, name: '京东' },
      { id: 6, name: '字节跳动' },
      { id: 7, name: '美团' },
      { id: 8, name: '滴滴' }
    ]
  }
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.hero-badge {
  display: inline-block;
  padding: 8px 20px;
  font-size: 14px;
  font-weight: 500;
  color: var(--primary-color);
  background: rgba(255, 255, 255, 0.8);
  border-radius: var(--radius-full);
  margin-bottom: 24px;
  box-shadow: var(--shadow-sm);
}

.title-line {
  display: block;
  background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.title-sub {
  display: block;
  font-size: 32px;
  font-weight: 400;
  color: var(--text-secondary);
  margin-top: 8px;
}

.hero-cta {
  display: flex;
  gap: 16px;
}

.scroll-indicator {
  position: absolute;
  bottom: 40px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
  color: var(--text-tertiary);
  font-size: 14px;
  animation: bounce 2s ease-in-out infinite;
}

@keyframes bounce {
  0%, 100% { transform: translateX(-50%) translateY(0); }
  50% { transform: translateX(-50%) translateY(10px); }
}

.mouse {
  width: 24px;
  height: 40px;
  border: 2px solid var(--text-tertiary);
  border-radius: 12px;
  position: relative;
}

.wheel {
  width: 4px;
  height: 8px;
  background: var(--text-tertiary);
  border-radius: 2px;
  position: absolute;
  top: 8px;
  left: 50%;
  transform: translateX(-50%);
  animation: scroll 2s ease-in-out infinite;
}

@keyframes scroll {
  0%, 100% { opacity: 1; transform: translateX(-50%) translateY(0); }
  50% { opacity: 0.3; transform: translateX(-50%) translateY(10px); }
}
</style>