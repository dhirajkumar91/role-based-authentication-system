import { useState } from "react";
import { loginUser } from "../services/authService";
import { Link } from "react-router-dom";

function Login() {

    const [form,setForm] = useState({
        email:"",
        password:""
    });

    const handleChange = (e)=>{
        setForm({...form,[e.target.name]:e.target.value});
    };

    const handleSubmit = async(e)=>{
        e.preventDefault();

        try{
            const res = await loginUser(form);
            localStorage.setItem("token",res.data.token);

            alert("Login Successful");

        }catch(err){
            alert("Invalid Credentials");
        }
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-gray-100">

            <div className="bg-white p-8 rounded-xl shadow-lg w-96">

                <h2 className="text-2xl font-bold text-center mb-6">
                    Login
                </h2>

                <form onSubmit={handleSubmit} className="space-y-4">

                    <input
                        name="email"
                        placeholder="Email"
                        onChange={handleChange}
                        className="w-full p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />

                    <input
                        name="password"
                        type="password"
                        placeholder="Password"
                        onChange={handleChange}
                        className="w-full p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />

                    <button
                        type="submit"
                        className="w-full bg-blue-600 text-white py-3 rounded-lg hover:bg-blue-700 transition"
                    >
                        Login
                    </button>

                </form>

                <p className="text-center mt-4 text-sm">
                    Don't have an account?
                    <Link to="/register" className="text-blue-600 ml-1">
                        Register
                    </Link>
                </p>

            </div>

        </div>
    );
}

export default Login;