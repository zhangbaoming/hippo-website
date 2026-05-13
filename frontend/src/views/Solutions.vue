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
          <span class="section-tag">解决方案</span>
          <h1 class="section-title">行业解决方案</h1>
          <p class="section-desc" style="margin: 0 auto;">
            定制化解决方案，助力企业数字化转型
          </p>
        </div>

        <div class="card-grid">
          <div class="solution-card" v-for="solution in solutions" :key="solution.id">
            <div class="solution-icon">🔹</div>
            <h3 class="card-title">{{ solution.title }}</h3>
            <p class="card-desc">{{ solution.description }}</p>
            <div class="solution-category">{{ solution.category }}</div>
          </div>
        </div>
      </div>
    </section>

    <section class="section" style="background: var(--bg-light);">
      <div class="container" style="text-align: center;">
        <h2 class="section-title">需要定制化方案？</h2>
        <p class="section-desc" style="margin: 0 auto 30px;">告诉我们您的需求，我们为您提供最适合的解决方案</p>
        <router-link to="/contact" class="btn btn-primary">联系我们</router-link>
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
import { getSolutions } from '@/api'

const solutions = ref([])

onMounted(async () => {
  try {
    const res = await getSolutions()
    solutions.value = res.data || []
  } catch (e) {
    console.error(e)
  }
})
</script>

<style scoped>
.solution-card {
  background: var(--white);
  border-radius: 16px;
  padding: 35px;
  box-shadow: var(--shadow);
  transition: all 0.3s;
  position: relative;
}

.solution-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 40px rgba(0, 0, 0, 0.12);
}

.solution-icon {
  font-size: 36px;
  margin-bottom: 15px;
}

.solution-category {
  display: inline-block;
  margin-top: 15px;
  padding: 5px 12px;
  background: var(--bg-light);
  border-radius: 15px;
  font-size: 12px;
  color: var(--light-text);
  text-transform: uppercase;
}
</style>