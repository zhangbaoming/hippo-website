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
          <span class="section-tag">联系我们</span>
          <h1 class="section-title">与我们合作</h1>
          <p class="section-desc" style="margin: 0 auto;">
            填写以下表单，我们会尽快与您联系
          </p>
        </div>

        <div class="contact-container">
          <form @submit.prevent="submitForm" class="contact-form">
            <div class="form-group">
              <label>姓名 *</label>
              <input v-model="form.name" type="text" required placeholder="请输入您的姓名" />
            </div>
            <div class="form-group">
              <label>邮箱 *</label>
              <input v-model="form.email" type="email" required placeholder="请输入您的邮箱" />
            </div>
            <div class="form-group">
              <label>电话</label>
              <input v-model="form.phone" type="tel" placeholder="请输入您的电话" />
            </div>
            <div class="form-group">
              <label>留言 *</label>
              <textarea v-model="form.message" required placeholder="请描述您的需求" rows="5"></textarea>
            </div>
            <button type="submit" class="btn btn-primary submit-btn" :disabled="submitting">
              {{ submitting ? '提交中...' : '提交留言' }}
            </button>
          </form>

          <div v-if="success" class="success-message">
            ✓ 留言提交成功！我们会尽快与您联系。
          </div>
        </div>

        <div class="contact-info">
          <div class="info-item">
            <div class="info-icon">📧</div>
            <div class="info-label">邮箱</div>
            <div class="info-value">contact@qianmian-tech.com</div>
          </div>
          <div class="info-item">
            <div class="info-icon">📞</div>
            <div class="info-label">电话</div>
            <div class="info-value">010-12345678</div>
          </div>
          <div class="info-item">
            <div class="info-icon">📍</div>
            <div class="info-label">地址</div>
            <div class="info-value">北京市朝阳区某街道</div>
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
import { ref } from 'vue'
import { submitContact } from '@/api'

const form = ref({
  name: '',
  email: '',
  phone: '',
  message: ''
})

const submitting = ref(false)
const success = ref(false)

const submitForm = async () => {
  submitting.value = true
  try {
    await submitContact(form.value)
    success.value = true
    form.value = { name: '', email: '', phone: '', message: '' }
  } catch (e) {
    alert('提交失败，请重试')
  } finally {
    submitting.value = false
  }
}
</script>

<style scoped>
.contact-container {
  max-width: 600px;
  margin: 0 auto 60px;
}

.success-message {
  text-align: center;
  padding: 20px;
  background: #d4edda;
  color: #155724;
  border-radius: 8px;
  margin-top: 20px;
}

.contact-info {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 30px;
  margin-top: 60px;
}

.info-item {
  text-align: center;
}

.info-icon {
  font-size: 36px;
  margin-bottom: 15px;
}

.info-label {
  font-size: 14px;
  color: var(--light-text);
  margin-bottom: 8px;
}

.info-value {
  font-size: 16px;
  font-weight: 500;
}

@media (max-width: 768px) {
  .contact-info {
    grid-template-columns: 1fr;
  }
}
</style>