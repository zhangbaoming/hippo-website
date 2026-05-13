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
          <div class="hero-badge">
            <span class="badge-dot"></span>
            AI · 大数据 · 云计算
          </div>
          <h1 class="hero-title">
            <span class="title-line">北京千面科技有限公司</span>
          </h1>
          <p class="hero-subtitle">让科技更有温度</p>
          <p class="hero-desc">
            致力于人工智能技术的创新与应用，以大数据和云计算为核心，<br>
            为企业客户提供智能化解决方案，赋能数字化转型。
          </p>
          <div class="hero-cta">
            <router-link to="/contact" class="btn btn-primary">联系我们</router-link>
            <router-link to="/services" class="btn btn-outline">了解更多</router-link>
          </div>
        </div>
        <div class="hero-visual">
          <div class="hero-graphic">
            <svg viewBox="0 0 400 400" class="hero-svg">
              <defs>
                <linearGradient id="heroGrad" x1="0%" y1="0%" x2="100%" y2="100%">
                  <stop offset="0%" style="stop-color:#0066ff;stop-opacity:1" />
                  <stop offset="100%" style="stop-color:#00ccaa;stop-opacity:1" />
                </linearGradient>
              </defs>
              <!-- Background circles -->
              <circle cx="200" cy="200" r="160" fill="#f0f5ff"/>
              <circle cx="200" cy="200" r="130" fill="url(#heroGrad)" opacity="0.1"/>
              <circle cx="200" cy="200" r="100" fill="url(#heroGrad)" opacity="0.2"/>
              
              <!-- Inner design -->
              <circle cx="200" cy="200" r="70" fill="white" stroke="url(#heroGrad)" stroke-width="3"/>
              <circle cx="200" cy="200" r="50" fill="url(#heroGrad)" opacity="0.3"/>
              
              <!-- Center icon - brain/AI -->
              <path d="M200 160 L220 190 L200 185 L180 190 Z" fill="url(#heroGrad)"/>
              <circle cx="200" cy="200" r="15" fill="url(#heroGrad)"/>
              <path d="M185 210 Q200 230 215 210" stroke="url(#heroGrad)" stroke-width="3" fill="none"/>
              
              <!-- Orbiting dots -->
              <circle cx="200" cy="120" r="8" fill="#0066ff">
                <animate attributeName="cy" values="120;130;120" dur="2s" repeatCount="indefinite"/>
              </circle>
              <circle cx="280" cy="200" r="8" fill="#00ccaa">
                <animate attributeName="cx" values="280;270;280" dur="2s" repeatCount="indefinite"/>
              </circle>
              <circle cx="200" cy="280" r="8" fill="#0066ff">
                <animate attributeName="cy" values="280;290;280" dur="2s" repeatCount="indefinite"/>
              </circle>
              <circle cx="120" cy="200" r="8" fill="#00ccaa">
                <animate attributeName="cx" values="120;130;120" dur="2s" repeatCount="indefinite"/>
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