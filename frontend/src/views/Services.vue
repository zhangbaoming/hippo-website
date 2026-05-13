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

    <section class="services" style="padding-top: 120px;">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">业务范围</span>
          <h1 class="section-title">我们的服务</h1>
          <p class="section-desc">基于前沿技术，为客户提供全面的智能化解决方案</p>
        </div>

        <div class="services-grid">
          <div class="service-card" v-for="service in services" :key="service.id">
            <div class="service-icon">
              <svg viewBox="0 0 48 48" fill="none">
                <path d="M24 4L4 14v20l20 10 20-10V14L24 4z" stroke="currentColor" stroke-width="2"/>
                <path d="M24 14v20M14 14l10 5v10M34 14l-10 5v10" stroke="currentColor" stroke-width="2"/>
              </svg>
            </div>
            <h3>{{ service.title }}</h3>
            <p>{{ service.description }}</p>
            <ul v-if="service.features">
              <li v-for="(feature, idx) in parseFeatures(service.features)" :key="idx">{{ feature }}</li>
            </ul>
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
import { getServices } from '@/api'

const isScrolled = ref(false)
const services = ref([])

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

const parseFeatures = (features) => {
  try {
    return JSON.parse(features)
  } catch {
    return []
  }
}

onMounted(async () => {
  window.addEventListener('scroll', handleScroll)
  try {
    const res = await getServices()
    services.value = res.data || []
  } catch (e) {
    services.value = [
      { id: 1, title: '人工智能', description: '提供机器学习、深度学习、自然语言处理等AI技术解决方案，帮助企业实现智能化升级。', features: '["AI模型训练与优化", "智能客服系统", "图像识别与分析", "智能推荐引擎"]' },
      { id: 2, title: '大数据', description: '数据采集、存储、分析、可视化一站式服务，挖掘数据价值，辅助决策。', features: '["数据仓库建设", "数据分析平台", "数据可视化", "数据治理咨询"]' },
      { id: 3, title: '云计算', description: '云架构设计、云迁移、云运维等服务，助力企业云端化转型。', features: '["云架构设计", "云迁移服务", "云运维管理", "混合云方案"]' },
      { id: 4, title: '软件开发', description: '企业级应用开发、Web应用、移动应用定制开发，满足多样化业务需求。', features: '["Web应用开发", "移动端开发", "企业管理系统", "API接口开发"]' },
      { id: 5, title: '数字化咨询', description: '数字化转型战略规划、流程优化咨询，帮助企业制定科学的数字化发展路径。', features: '["数字化战略规划", "业务流程优化", "IT架构咨询", "技术培训"]' },
      { id: 6, title: '物联网', description: 'IoT设备接入、平台开发、边缘计算等物联网综合解决方案。', features: '["IoT平台开发", "设备接入管理", "边缘计算", "智能硬件集成"]' }
    ]
  }
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.services-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 30px;
}

.service-card {
  padding: 40px 30px;
  background: var(--bg-primary);
  border-radius: var(--radius-lg);
  box-shadow: var(--shadow-sm);
  transition: all var(--transition-normal);
}

.service-card:hover {
  transform: translateY(-8px);
  box-shadow: var(--shadow-lg);
}

.service-icon {
  width: 60px;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: var(--bg-tertiary);
  border-radius: var(--radius-md);
  margin-bottom: 24px;
}

.service-icon svg {
  width: 32px;
  height: 32px;
  color: var(--primary-color);
}

.service-card h3 {
  font-size: 22px;
  font-weight: 600;
  margin-bottom: 16px;
  color: var(--text-primary);
}

.service-card > p {
  font-size: 15px;
  color: var(--text-secondary);
  margin-bottom: 20px;
  line-height: 1.7;
}

.service-card ul {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.service-card li {
  position: relative;
  padding-left: 20px;
  font-size: 14px;
  color: var(--text-secondary);
}

.service-card li::before {
  content: '';
  position: absolute;
  left: 0;
  top: 8px;
  width: 6px;
  height: 6px;
  background: var(--primary-color);
  border-radius: 50%;
}

@media (max-width: 1024px) {
  .services-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .services-grid {
    grid-template-columns: 1fr;
  }
}
</style>