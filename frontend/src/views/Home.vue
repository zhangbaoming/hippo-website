<template>
  <div>
    <!-- Navigation -->
    <nav class="navbar">
      <div class="container">
        <router-link to="/" class="logo">
          <span class="logo-icon">🦁</span>
          <span class="logo-text">千面科技</span>
        </router-link>
        <ul class="nav-links">
          <li><router-link to="/">首页</router-link></li>
          <li><router-link to="/about">关于我们</router-link></li>
          <li><router-link to="/services">业务范围</router-link></li>
          <li><router-link to="/solutions">解决方案</router-link></li>
          <li><router-link to="/contact">联系我们</router-link></li>
        </ul>
      </div>
    </nav>

    <!-- Hero -->
    <section class="hero">
      <div class="container">
        <div class="hero-badge">AI Powered</div>
        <h1 class="hero-title">北京千面科技有限公司</h1>
        <p class="hero-subtitle">提供优质的互联网解决方案</p>
        <p class="hero-desc">
          我们致力于为客户提供优质的互联网解决方案，包括软件开发、UI/UX设计、云服务、数据分析等一站式服务。
        </p>
        <div style="display: flex; gap: 15px; justify-content: center;">
          <router-link to="/contact" class="btn btn-primary">联系我们</router-link>
          <router-link to="/services" class="btn btn-outline">了解更多</router-link>
        </div>
      </div>
    </section>

    <!-- Services Preview -->
    <section class="section">
      <div class="container">
        <span class="section-tag">我们的服务</span>
        <h2 class="section-title">为客户提供全方位服务</h2>
        <p class="section-desc">专业的团队，丰富的经验，为您的数字化转型保驾护航。</p>
        <div class="card-grid">
          <div class="card" v-for="service in services" :key="service.id">
            <div class="card-icon">{{ getIcon(service.icon) }}</div>
            <h3 class="card-title">{{ service.title }}</h3>
            <p class="card-desc">{{ service.description }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Solutions Preview -->
    <section class="section" style="background: var(--bg-light);">
      <div class="container">
        <span class="section-tag">解决方案</span>
        <h2 class="section-title">行业领先解决方案</h2>
        <p class="section-desc">针对不同行业提供定制化解决方案。</p>
        <div class="card-grid">
          <div class="card" v-for="solution in solutions" :key="solution.id">
            <h3 class="card-title">{{ solution.title }}</h3>
            <p class="card-desc">{{ solution.description }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Contact CTA -->
    <section class="section">
      <div class="container" style="text-align: center;">
        <h2 class="section-title">准备好开始您的项目了吗？</h2>
        <p class="section-desc" style="margin: 0 auto 30px;">立即联系我们，开启您的数字化转型之旅</p>
        <router-link to="/contact" class="btn btn-primary">开始合作</router-link>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <div class="footer-content">
          <div>
            <h4>关于千面科技</h4>
            <p style="color: rgba(255,255,255,0.6); font-size: 14px;">
              北京千面科技有限公司是一家专注于互联网应用服务的科技企业，致力于为客户提供优质的互联网解决方案。
            </p>
          </div>
          <div>
            <h4>快速链接</h4>
            <ul class="footer-links">
              <li><router-link to="/">首页</router-link></li>
              <li><router-link to="/about">关于我们</router-link></li>
              <li><router-link to="/services">业务范围</router-link></li>
              <li><router-link to="/solutions">解决方案</router-link></li>
            </ul>
          </div>
          <div>
            <h4>服务项目</h4>
            <ul class="footer-links">
              <li><router-link to="/services">软件开发</router-link></li>
              <li><router-link to="/services">UI/UX设计</router-link></li>
              <li><router-link to="/services">云服务</router-link></li>
              <li><router-link to="/services">数据分析</router-link></li>
            </ul>
          </div>
          <div>
            <h4>联系我们</h4>
            <p style="color: rgba(255,255,255,0.6); font-size: 14px;">
              contact@qianmian-tech.com<br>
              010-12345678
            </p>
          </div>
        </div>
        <div class="footer-bottom">
          © 2024 北京千面科技有限公司. All Rights Reserved.
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getServices, getSolutions } from '@/api'

const services = ref([])
const solutions = ref([])

const iconMap = {
  code: '💻',
  palette: '🎨',
  cloud: '☁️',
  analytics: '📊',
  campaign: '📢',
  support: '🔧'
}

const getIcon = (icon) => iconMap[icon] || '🔹'

onMounted(async () => {
  try {
    const res = await getServices()
    services.value = res.data || []
  } catch (e) {
    console.error(e)
  }
  try {
    const res = await getSolutions()
    solutions.value = (res.data || []).slice(0, 4)
  } catch (e) {
    console.error(e)
  }
})
</script>

<style scoped>
.hero-badge {
  display: inline-block;
  padding: 8px 20px;
  background: rgba(255,255,255,0.2);
  border-radius: 20px;
  font-size: 14px;
  margin-bottom: 20px;
}
</style>