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
        <div class="about-header">
          <span class="section-tag">关于我们</span>
          <h1 class="section-title">{{ companyInfo.name || '北京千面科技有限公司' }}</h1>
          <p class="section-desc" style="max-width: 800px;">
            {{ companyInfo.description || '我们是一家专注于互联网应用服务的科技企业，致力于为客户提供优质的互联网解决方案。' }}
          </p>
        </div>

        <div class="stats-grid">
          <div class="stat-item">
            <div class="stat-number">{{ companyInfo.employeeCount || '50+' }}</div>
            <div class="stat-label">员工数量</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">{{ companyInfo.projectCount || '200+' }}</div>
            <div class="stat-label">完成项目</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">{{ companyInfo.clientCount || '100+' }}</div>
            <div class="stat-label">合作客户</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">{{ companyInfo.yearsExperience || '10+' }}</div>
            <div class="stat-label">行业经验</div>
          </div>
        </div>
      </div>
    </section>

    <section class="section" style="background: var(--bg-light);">
      <div class="container">
        <h2 class="section-title" style="text-align: center; margin-bottom: 40px;">我们的愿景</h2>
        <div class="vision-card">
          <p>{{ companyInfo.vision || '成为客户最信赖的互联网服务合作伙伴' }}</p>
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
import { getAbout } from '@/api'

const companyInfo = ref({})

onMounted(async () => {
  try {
    const res = await getAbout()
    companyInfo.value = res.data || {}
  } catch (e) {
    console.error(e)
  }
})
</script>

<style scoped>
.about-header {
  text-align: center;
  margin-bottom: 60px;
}

.stats-grid {
  max-width: 900px;
  margin: 60px auto 0;
}

.vision-card {
  background: var(--white);
  padding: 50px;
  border-radius: 16px;
  text-align: center;
  font-size: 24px;
  font-weight: 500;
  color: var(--primary-color);
  max-width: 700px;
  margin: 0 auto;
  box-shadow: var(--shadow);
}
</style>