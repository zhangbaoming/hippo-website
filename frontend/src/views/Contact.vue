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

    <section class="contact" style="padding-top: 120px;">
      <div class="container">
        <div class="section-header">
          <span class="section-tag">联系我们</span>
          <h1 class="section-title">联系我们</h1>
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
          <form class="contact-form" @submit.prevent="submitForm">
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
            <button type="submit" class="btn btn-primary" :disabled="submitting">
              {{ submitting ? '提交中...' : '提交留言' }}
            </button>
          </form>
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
import { submitContact } from '@/api'

const isScrolled = ref(false)
const submitting = ref(false)

const form = ref({
  name: '',
  email: '',
  phone: '',
  message: ''
})

const handleScroll = () => {
  isScrolled.value = window.scrollY > 50
}

const submitForm = async () => {
  submitting.value = true
  try {
    await submitContact(form.value)
    alert('留言提交成功！')
    form.value = { name: '', email: '', phone: '', message: '' }
  } catch (e) {
    alert('提交失败，请重试')
  } finally {
    submitting.value = false
  }
}

onMounted(() => {
  window.addEventListener('scroll', handleScroll)
})

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll)
})
</script>

<style scoped>
.contact-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 60px;
}

.contact-info {
  display: flex;
  flex-direction: column;
  gap: 30px;
}

.info-item {
  display: flex;
  gap: 20px;
  padding: 24px;
  background: var(--bg-secondary);
  border-radius: var(--radius-lg);
  transition: all var(--transition-normal);
}

.info-item:hover {
  box-shadow: var(--shadow-md);
}

.info-icon {
  font-size: 32px;
}

.info-content h4 {
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 8px;
  color: var(--text-primary);
}

.info-content p {
  font-size: 15px;
  color: var(--text-secondary);
}

.contact-form {
  padding: 40px;
  background: var(--bg-secondary);
  border-radius: var(--radius-xl);
}

.contact-form h3 {
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 30px;
  color: var(--text-primary);
}

.form-group {
  margin-bottom: 20px;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 16px 20px;
  font-size: 15px;
  color: var(--text-primary);
  background: var(--bg-primary);
  border: 1px solid var(--border-color);
  border-radius: var(--radius-md);
  transition: all var(--transition-fast);
}

.form-group input:focus,
.form-group textarea:focus {
  border-color: var(--primary-color);
  box-shadow: 0 0 0 3px rgba(0, 102, 255, 0.1);
}

.form-group input::placeholder,
.form-group textarea::placeholder {
  color: var(--text-tertiary);
}

.form-group textarea {
  resize: vertical;
  min-height: 120px;
}

.contact-form .btn {
  width: 100%;
}

@media (max-width: 768px) {
  .contact-content {
    grid-template-columns: 1fr;
  }
}
</style>