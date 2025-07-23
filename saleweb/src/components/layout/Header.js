import { useEffect, useState } from "react";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import { Link } from "react-router-dom";

const Header = () => {
    const [categories, setCategories] = useState([]);

    const loadCates = async () => {
        let res = await Apis.get(endpoints['categories']);
        setCategories(res.data);
    }

    useEffect(() => {
        loadCates();
    }, []);

    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <Nav.Link href="#home">Home</Nav.Link>
                    <Link to="/" className="nav-link" >Trang chu</Link>
                    <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                        {categories.map(c => <Link key={c.id} to = {`/?categoryId=${c.id}`} className="dropdown-item" href="#action/3.1">{c.name}</Link>)}
                        
                    
                    </NavDropdown>
                </Nav>
                </Navbar.Collapse>
            </Container>
            </Navbar>
        </>
    );
}

export default Header;