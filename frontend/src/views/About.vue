<template>
  <div>
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
      </div>
    </nav>

    <section class="section" style="padding-top: 120px;">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">关于我们</span>
          <h1 class="section-title">北京千面科技有限公司</h1>
          <p class="section-desc">
            千面科技是一家专注于人工智能、大数据、云计算等前沿技术的创新型科技企业。公司成立于北京，汇聚了一批来自国内外知名科技公司的技术精英和行业专家。
          </p>
        </div>

        <div class="about-content">
          <div class="about-info">
            <h3>公司简介</h3>
            <p class="about-intro">
              千面科技是一家专注于人工智能、大数据、云计算等前沿技术的创新型科技企业。公司成立于北京，汇聚了一批来自国内外知名科技公司的技术精英和行业专家。
            </p>
            <p>
              我们坚持以用户需求为导向，以技术创新为驱动，为企业和机构客户提供智能化解决方案。从技术咨询、方案设计到落地实施，我们提供全方位的技术服务，帮助客户实现数字化转型和业务升级。
            </p>
            <div class="about-stats">
              <div class="stat-item">
                <span class="stat-number">50+</span>
                <span class="stat-label">核心技术成员</span>
              </div>
              <div class="stat-item">
                <span class="stat-number">200+</span>
                <span class="stat-label">完成项目</span>
              </div>
              <div class="stat-item">
                <span class="stat-number">100+</span>
                <span class="stat-label">服务企业客户</span>
              </div>
            </div>
          </div>
          <div class="about-image">
            <div class="image-placeholder">
              <svg viewBox="0 0 400 300" class="placeholder-svg">
                <rect width="400" height="300" fill="#f0f5ff"/>
                <text x="200" y="150" text-anchor="middle" fill="#0066ff" font-size="18" opacity="0.5">千面科技大厦</text>
                <rect x="50" y="50" width="300" height="200" fill="none" stroke="#0066ff" stroke-width="1" stroke-dasharray="5,5" opacity="0.3"/>
              </svg>
            </div>
          </div>
        </div>

        <div class="about-values">
          <div class="value-card">
            <div class="value-icon">🎯</div>
            <h4>企业愿景</h4>
            <p>成为全球领先的人工智能解决方案提供商，让AI技术惠及千行百业</p>
          </div>
          <div class="value-card">
            <div class="value-icon">💡</div>
            <h4>企业使命</h4>
            <p>以技术创新为客户创造价值，推动社会进步与发展</p>
          </div>
          <div class="value-card">
            <div class="value-icon">🤝</div>
            <h4>核心价值观</h4>
            <p>创新、诚信、协作、共赢</p>
          </div>
        </div>
      </div>
    </section>

    <footer class="footer">
      <div class="container">
        <div class="footer-bottom">
          <p>© 2024 北京千面科技有限公司 版权所有</p>
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import { getAbout } from '@/api'

const isScrolled = ref(false)
const companyInfo = ref({})

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

onMounted(async () => {
  window.addEventListener('scroll', handleScroll)
  try {
    const res = await getAbout()
    companyInfo.value = res.data || {}
  } catch (e) {
    console.error(e)
  }
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.about-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 60px;
  align-items: center;
  margin-bottom: 60px;
}

.about-info h3 {
  font-size: 32px;
  font-weight: 700;
  margin-bottom: 24px;
  color: var(--text-primary);
}

.about-intro {
  font-size: 18px;
  color: var(--text-secondary);
  margin-bottom: 20px;
}

.about-stats {
  display: flex;
  gap: 40px;
  margin-top: 40px;
  padding-top: 40px;
  border-top: 1px solid var(--border-color);
}

.stat-item {
  display: flex;
  flex-direction: column;
}

.stat-number {
  font-size: 36px;
  font-weight: 700;
  color: var(--primary-color);
}

.stat-label {
  font-size: 14px;
  color: var(--text-tertiary);
}

.about-image .image-placeholder {
  border-radius: var(--radius-lg);
  overflow: hidden;
  box-shadow: var(--shadow-lg);
}

.about-values {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 30px;
  margin-top: 60px;
  padding-top: 60px;
  border-top: 1px solid var(--border-color);
}

.value-card {
  text-align: center;
  padding: 30px;
  background: var(--bg-secondary);
  border-radius: var(--radius-lg);
  transition: all var(--transition-normal);
}

.value-card:hover {
  transform: translateY(-8px);
  box-shadow: var(--shadow-md);
}

.value-icon {
  font-size: 40px;
  margin-bottom: 16px;
}

.value-card h4 {
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 12px;
  color: var(--text-primary);
}

.value-card p {
  font-size: 15px;
  color: var(--text-secondary);
}

@media (max-width: 768px) {
  .about-content {
    grid-template-columns: 1fr;
  }
  .about-values {
    grid-template-columns: 1fr;
  }
}
</style>