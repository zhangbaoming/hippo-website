import axios from 'axios'

const api = axios.create({
  baseURL: '/api',
  timeout: 10000
})

api.interceptors.response.use(
  response => response.data,
  error => Promise.reject(error)
)

export const getAbout = () => api.get('/about')
export const getServices = () => api.get('/services')
export const getSolutions = (category) => api.get('/solutions', { params: { category } })
export const getPartners = () => api.get('/partners')
export const submitContact = (data) => api.post('/contact', data)

export default api