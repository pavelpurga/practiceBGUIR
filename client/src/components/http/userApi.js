import {$host,$authHost} from "./index";
import jwt_decode from "jwt-decode"
export const registration = async (name,password) => {
        const {data} = await $host.post('api/auth/login',{name,password,role:'ADMIN'})
    return jwt_decode(data.token)
}

export const login = async (name,password) => {
    const {data} = await $host.post('api/auth/login',{name,password})
    localStorage.setItem('token',data.token)
    return jwt_decode(data.token)
}

export const check = async () => {
    const {data} = await $authHost.post('api/auth/login')
    localStorage.setItem('token',data.token)
    return jwt_decode(data.token)
}