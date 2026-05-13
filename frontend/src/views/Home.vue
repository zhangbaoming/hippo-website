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
            <span class="title-line">千面科技</span>
            <span class="title-sub">让科技更有温度</span>
          </h1>
          <p class="hero-desc">
            致力于人工智能技术的创新与应用，以大数据和云计算为核心，<br>
            为企业客户提供智能化解决方案，赋能数字化转型。
          </p>
          <div class="hero-cta">
            <router-link to="/contact" class="btn btn-primary">了解更多</router-link>
            <router-link to="/services" class="btn btn-outline">我们的服务</router-link>
          </div>
        </div>
        <div class="hero-visual">
          <div class="hero-graphic">
            <svg viewBox="0 0 400 400" class="hero-svg">
              <defs>
                <linearGradient id="grad1" x1="0%" y1="0%" x2="100%" y2="100%">
                  <stop offset="0%" style="stop-color:#0066ff;stop-opacity:0.3" />
                  <stop offset="100%" style="stop-color:#00ccaa;stop-opacity:0.3" />
                </linearGradient>
              </defs>
              <circle cx="200" cy="200" r="150" fill="url(#grad1)" />
              <circle cx="200" cy="200" r="100" fill="none" stroke="#0066ff" stroke-width="2" opacity="0.5">
                <animateTransform attributeName="transform" type="rotate" from="0 200 200" to="360 200 200" dur="20s" repeatCount="indefinite" />
              </circle>
              <circle cx="200" cy="200" r="60" fill="none" stroke="#00ccaa" stroke-width="2" opacity="0.5">
                <animateTransform attributeName="transform" type="rotate" from="360 200 200" to="0 200 200" dur="15s" repeatCount="indefinite" />
              </circle>
              <text x="200" y="205" text-anchor="middle" fill="#0066ff" font-size="24" font-weight="bold">AI</text>
            </svg>
          </div>
        </div>
      </div>
      <div class="scroll-indicator">
        <div class="mouse">
          <div class="wheel"></div>
        </div>
        <span>向下滚动</span>
      </div>
    </section>

    <!-- Services Preview -->
    <section class="services" id="services">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">业务范围</span>
          <h2 class="section-title">我们的服务</h2>
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
          </div>
        </div>
      </div>
    </section>

    <!-- Solutions Preview -->
    <section class="solutions" id="solutions">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">解决方案</span>
          <h2 class="section-title">行业解决方案</h2>
          <p class="section-desc">深耕多个行业，积累丰富经验，提供专业解决方案</p>
        </div>
        <div class="solutions-tabs">
          <button 
            v-for="(solutions, category) in groupedSolutions" 
            :key="category"
            class="tab-btn"
            :class="{ active: activeCategory === category }"
            @click="activeCategory = category"
          >
            {{ category }}
          </button>
        </div>
        <div class="solutions-content">
          <div class="solution-panel active" v-if="currentSolutions">
            <div class="solution-info">
              <h3>{{ currentSolutions.title }}</h3>
              <p>{{ currentSolutions.description }}</p>
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

    <!-- Contact CTA -->
    <section class="contact" id="contact">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">联系我们</span>
          <h2 class="section-title">联系我们</h2>
          <p class="section-desc">期待与您的合作，欢迎随时联系我们</p>
        </div>
        <div class="contact-content">
          <div class="contact-info">
            <div class="info-item">
              <div class="info-icon">📍</div>
              <div class="info-content">
                <h4>公司地址</h4>
                <p>北京市海淀区中关村科技园</p>
              </div>
            </div>
            <div class="info-item">
              <div class="info-icon">📧</div>
              <div class="info-content">
                <h4>邮箱</h4>
                <p>contact@qianmian-tech.com</p>
              </div>
            </div>
            <div class="info-item">
              <div class="info-icon">📱</div>
              <div class="info-content">
                <h4>电话</h4>
                <p>010-12345678</p>
              </div>
            </div>
            <div class="info-item">
              <div class="info-icon">🌐</div>
              <div class="info-content">
                <h4>官网</h4>
                <p>www.qianmian-tech.com</p>
              </div>
            </div>
          </div>
          <form class="contact-form" @submit.prevent="handleSubmit">
            <h3>在线留言</h3>
            <div class="form-group">
              <input v-model="form.name" type="text" placeholder="您的姓名" required>
            </div>
            <div class="form-group">
              <input v-model="form.email" type="email" placeholder="您的邮箱" required>
            </div>
            <div class="form-group">
              <input v-model="form.phone" type="tel" placeholder="联系电话">
            </div>
            <div class="form-group">
              <textarea v-model="form.message" placeholder="请输入您的留言内容" rows="5" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">提交留言</button>
          </form>
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
import { ref, computed, onMounted, onUnmounted } from 'vue'
import { getServices, getSolutions, getPartners, submitContact } from '@/api'

const isScrolled = ref(false)
const showMobileMenu = ref(false)
const activeCategory = ref('金融')

const services = ref([])
const solutions = ref([])
const partners = ref([])

const form = ref({
  name: '',
  email: '',
  phone: '',
  message: ''
})

const groupedSolutions = computed(() => {
  const grouped = {}
  solutions.value.forEach(s => {
    if (!grouped[s.category]) {
      grouped[s.category] = s
    }
  })
  return grouped
})

const currentSolutions = computed(() => groupedSolutions.value[activeCategory.value])

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

const handleSubmit = async () => {
  try {
    await submitContact(form.value)
    alert('留言提交成功！')
    form.value = { name: '', email: '', phone: '', message: '' }
  } catch (e) {
    console.error(e)
  }
}

onMounted(async () => {
  window.addEventListener('scroll', handleScroll)
  try {
    const res = await getServices()
    services.value = res.data || []
  } catch (e) {
    services.value = [
      { id: 1, title: '人工智能', description: '提供机器学习、深度学习、自然语言处理等AI技术解决方案' },
      { id: 2, title: '大数据', description: '数据采集、存储、分析、可视化一站式服务' },
      { id: 3, title: '云计算', description: '云架构设计、云迁移、云运维等服务' }
    ]
  }
  try {
    const res = await getSolutions()
    solutions.value = res.data || []
  } catch (e) {
    solutions.value = [
      { id: 1, title: '金融行业解决方案', description: '为银行、保险、证券等金融机构提供智能风控、智能客服解决方案', category: '金融' },
      { id: 2, title: '零售行业解决方案', description: '为零售企业提供智能供应链、会员管理、数据分析等解决方案', category: '零售' },
      { id: 3, title: '制造业解决方案', description: '为制造企业提供智能制造、工业物联网等解决方案', category: '制造' },
      { id: 4, title: '医疗健康解决方案', description: '为医疗机构提供智慧医疗、健康管理等解决方案', category: '医疗' }
    ]
  }
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