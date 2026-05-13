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

    <section class="solutions" style="padding-top: 120px;">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">解决方案</span>
          <h1 class="section-title">行业解决方案</h1>
          <p class="section-desc">深耕多个行业，积累丰富经验，提供专业解决方案</p>
        </div>

        <div class="solutions-tabs">
          <button 
            v-for="s in solutions" 
            :key="s.id"
            class="tab-btn"
            :class="{ active: activeSolution?.id === s.id }"
            @click="activeSolution = s"
          >
            {{ s.category }}
          </button>
        </div>

        <div class="solutions-content" v-if="activeSolution">
          <div class="solution-panel active">
            <div class="solution-info">
              <h3>{{ activeSolution.title }}</h3>
              <p>{{ activeSolution.description }}</p>
              <ul class="solution-features">
                <li><strong>{{ activeSolution.category }}：</strong>{{ activeSolution.description }}</li>
              </ul>
            </div>
            <div class="solution-visual">
              <div class="solution-graphic">
                <svg viewBox="0 0 300 200">
                  <rect width="300" height="200" fill="#f8fafc"/>
                  <rect x="20" y="30" width="80" height="60" rx="4" fill="#0066ff" opacity="0.1"/>
                  <rect x="110" y="30" width="80" height="60" rx="4" fill="#00ccaa" opacity="0.1"/>
                  <rect x="200" y="30" width="80" height="60" rx="4" fill="#0066ff" opacity="0.1"/>
                  <circle cx="50" cy="60" r="15" fill="#0066ff"/>
                  <circle cx="150" cy="60" r="15" fill="#00ccaa"/>
                  <circle cx="250" cy="60" r="15" fill="#0066ff"/>
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section style="background: var(--bg-secondary); padding: 80px 0;">
      <div class="container" style="text-align: center;">
        <h2 class="section-title">需要定制化方案？</h2>
        <p class="section-desc" style="margin: 0 auto 30px;">告诉我们您的需求，我们为您提供最适合的解决方案</p>
        <router-link to="/contact" class="btn btn-primary">联系我们</router-link>
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
import { getSolutions } from '@/api'

const isScrolled = ref(false)
const solutions = ref([])
const activeSolution = ref(null)

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

onMounted(async () => {
  window.addEventListener('scroll', handleScroll)
  try {
    const res = await getSolutions()
    solutions.value = res.data || []
  } catch (e) {
    solutions.value = [
      { id: 1, title: '金融行业解决方案', description: '为银行、保险、证券等金融机构提供智能风控、智能客服、精准营销等解决方案。', category: '金融' },
      { id: 2, title: '零售行业解决方案', description: '为零售企业提供智能供应链、会员管理、数据分析等数字化解决方案。', category: '零售' },
      { id: 3, title: '制造业解决方案', description: '为制造企业提供智能制造、工业物联网、预测性维护等解决方案。', category: '制造' },
      { id: 4, title: '医疗健康解决方案', description: '为医疗机构提供智慧医疗、健康管理等解决方案。', category: '医疗' }
    ]
  }
  if (solutions.value.length > 0) {
    activeSolution.value = solutions.value[0]
  }
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.solutions-tabs {
  display: flex;
  justify-content: center;
  gap: 16px;
  margin-bottom: 50px;
}

.tab-btn {
  padding: 14px 32px;
  font-size: 16px;
  font-weight: 500;
  color: var(--text-secondary);
  background: var(--bg-secondary);
  border-radius: var(--radius-md);
  transition: all var(--transition-normal);
}

.tab-btn:hover {
  color: var(--primary-color);
  background: var(--bg-tertiary);
}

.tab-btn.active {
  color: var(--text-light);
  background: var(--primary-color);
}

.solutions-content {
  max-width: 1000px;
  margin: 0 auto;
}

.solution-panel {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 60px;
  align-items: center;
  padding: 50px;
  background: var(--bg-secondary);
  border-radius: var(--radius-xl);
}

.solution-info h3 {
  font-size: 28px;
  font-weight: 700;
  margin-bottom: 20px;
  color: var(--text-primary);
}

.solution-info > p {
  font-size: 16px;
  color: var(--text-secondary);
  margin-bottom: 24px;
  line-height: 1.8;
}

.solution-features {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.solution-features li {
  font-size: 15px;
  color: var(--text-secondary);
  line-height: 1.6;
}

.solution-features strong {
  color: var(--text-primary);
}

.solution-visual {
  display: flex;
  align-items: center;
  justify-content: center;
}

.solution-graphic {
  width: 100%;
  max-width: 300px;
}

@media (max-width: 768px) {
  .solution-panel {
    grid-template-columns: 1fr;
  }
  .solutions-tabs {
    flex-wrap: wrap;
  }
}
</style>