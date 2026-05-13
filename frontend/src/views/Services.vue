<template>
  <div>
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

    <section class="section" style="padding-top: 120px;">
      <div class="container">
        <div style="text-align: center; margin-bottom: 50px;">
          <span class="section-tag">业务范围</span>
          <h1 class="section-title">我们的服务</h1>
          <p class="section-desc" style="margin: 0 auto;">
            为客户提供全方位的互联网服务
          </p>
        </div>

        <div class="card-grid">
          <div class="service-card" v-for="service in services" :key="service.id">
            <div class="card-icon">{{ getIcon(service.icon) }}</div>
            <h3 class="card-title">{{ service.title }}</h3>
            <p class="card-desc">{{ service.description }}</p>
            <ul class="feature-list" v-if="service.features">
              <li v-for="(feature, idx) in parseFeatures(service.features)" :key="idx">
                {{ feature }}
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <footer class="footer">
      <div class="container">
        <div class="footer-bottom">
          © 2024 北京千面科技有限公司. All Rights Reserved.
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getServices } from '@/api'

const services = ref([])

const iconMap = {
  code: '💻',
  palette: '🎨',
  cloud: '☁️',
  analytics: '📊',
  campaign: '📢',
  support: '🔧'
}

const getIcon = (icon) => iconMap[icon] || '🔹'

const parseFeatures = (features) => {
  try {
    return JSON.parse(features)
  } catch {
    return []
  }
}

onMounted(async () => {
  try {
    const res = await getServices()
    services.value = res.data || []
  } catch (e) {
    console.error(e)
  }
})
</script>

<style scoped>
.service-card {
  background: var(--white);
  border-radius: 16px;
  padding: 35px;
  box-shadow: var(--shadow);
  transition: all 0.3s;
}

.service-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 40px rgba(0, 0, 0, 0.12);
}

.feature-list {
  list-style: none;
  margin-top: 20px;
  padding-top: 20px;
  border-top: 1px solid #eee;
}

.feature-list li {
  padding: 6px 0;
  color: var(--light-text);
  font-size: 14px;
}

.feature-list li::before {
  content: '✓';
  color: var(--secondary-color);
  margin-right: 8px;
  font-weight: bold;
}
</style>