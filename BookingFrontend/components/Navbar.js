import logo from './images/placeholderlogo.png';
import Button from "react-bootstrap/Button";
import { Link } from 'react-router-dom';
import "./Navbar.css";

export default function Navbar (props) {
    const { toggleForm, loginStatus, toggleLoginStatus, userType, toggleUserType } = props;

    function handleLogOut() {
        toggleLoginStatus(false);
        toggleForm("login");
        toggleUserType("");
    }

    return(
        <div>
            {
                loginStatus ? (
                    userType === "client" ? (
                        <div>
                            <nav className = "navbar">
                                <img src = {logo} className = "logo" alt = "Logo"></img>
                                <div className = "links">
                                    <Link className = "linkstyle" to = "/"> Home </Link>
                                    <Link className = "linkstyle" to = "/MyTravels"> MyTravels </Link>
                                    <Link className = "linkstyle" to = "/BlankPage" onClick = {handleLogOut}> LogOut </Link>
                                </div>
                            </nav>
                        </div>
                    ) :
                    <div>
                        <nav className = "navbar">
                            <img src = {logo} className = "logo" alt = "Logo"></img>
                            <div className = "links">
                                <Link className = "linkstyle" to = "/"> Home </Link>
                                <Link className = "linkstyle" to = "/Admin"> Admin </Link>
                                <Link className = "linkstyle" to = "/BlankPage" onClick = {handleLogOut}> LogOut </Link>
                            </div>
                        </nav>
                    </div>
                ) :
                <div>
                    <nav className = "navbar">
                        <img src = {logo} className = "logo" alt = "Logo"></img>
                        <div className = "links">
                            <Link className = "linkstyle" to = "/"> Home </Link>
                            <Link className = "linkstyle" to = "/LogIn"> LogIn </Link>
                        </div>
                    </nav>
                </div>
            }
        </div>
    );
}