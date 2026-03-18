import { useState } from "react";
import { registerUser } from "../services/authService";
import { Link, useNavigate } from "react-router-dom";

function Register(){

    const navigate = useNavigate();

    const [form,setForm] = useState({
        username:"",
        email:"",
        password:"",
        roleName:"USER"
    });

    const handleChange = (e)=>{
        setForm({...form,[e.target.name]:e.target.value});
    };

    const handleSubmit = async(e)=>{
        e.preventDefault();

        try{
            await registerUser(form);
            alert("Registration Successful");
            navigate("/login");

        }catch(err){
            alert("Registration Failed");
        }
    };

    return(
        <div className="min-h-screen flex items-center justify-center bg-gray-100">

            <div className="bg-white p-8 rounded-xl shadow-lg w-96">

                <h2 className="text-2xl font-bold text-center mb-6">
                    Register
                </h2>

                <form onSubmit={handleSubmit} className="space-y-4">

                    <input
                        name="username"
                        placeholder="Username"
                        onChange={handleChange}
                        className="w-full p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500"
                    />

                    <input
                        name="email"
                        placeholder="Email"
                        onChange={handleChange}
                        className="w-full p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500"
                    />

                    <input
                        name="password"
                        type="password"
                        placeholder="Password"
                        onChange={handleChange}
                        className="w-full p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-green-500"
                    />

                    <select
                        name="roleName"
                        onChange={handleChange}
                        className="w-full p-3 border rounded-lg"
                    >
                        <option value="USER">USER</option>
                        <option value="MANAGER">FACULTY</option>
                    </select>

                    <button
                        type="submit"
                        className="w-full bg-green-600 text-white py-3 rounded-lg hover:bg-green-700 transition"
                    >
                        Register
                    </button>

                </form>

                <p className="text-center mt-4 text-sm">
                    Already have an account?
                    <Link to="/login" className="text-blue-600 ml-1">
                        Login
                    </Link>
                </p>

            </div>

        </div>
    );
}

export default Register;