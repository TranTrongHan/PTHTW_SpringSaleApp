import { useEffect, useState } from "react";
import { Button, Card, Col, Form, Row, Spinner } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useSearchParams } from "react-router-dom";

const Home = () => {
    const [products, setProducts] = useState(null);
    const [page, setPage] = useState(1);
    const [loading, setLoading] = useState(true);
    const[q,setQ] = useState(null);
    const [param] = useSearchParams();
    const loadProduct = async () => {
        let url = `${endpoints['products']}?page=${page}`;
        console.log(url)
        if(q)
            url = `${url}&kw=${q}`
        let cateId = param.get("categoryId");
        if(cateId)
            url = `${url}&categoryId=${cateId}`
        try {
            setLoading(true);
            let res = await Apis.get(url);
            if(res.data.length == 0)
                page = 0;
            else {
                if(page <=1)
                    setProducts(res.data);
                else 
                    setProducts([...products, ...res.data]);
            }
           
        } catch (error) {
            console.error(error);
        } finally {
            setLoading(false);
        }
    }
    useEffect(() => {
        let timer = setTimeout(() =>{
            if(page > 0)
                loadProduct();
        },500)
        return () => clearTimeout(timer);
       
    }, [page, q,param]);

    useEffect(() => {
        setPage(1);
    },[q, param])

    const loadMore = () => {
        setPage(page+1);
    }
    return (
        <>
            <Form>
                <Form.Group className="mb-3 mt-2">
                  
                    <Form.Control value = {q} onChange={e => setQ(e.target.value)} type="email" placeholder="Tim kiem san pham" />
                </Form.Group>
              
            </Form>
            {loading ? <Spinner animation="grow" variant="primary" /> : <>
                <Row>
                    {products.map(p => <Col key={p.id} md={3} xs={6}>
                        <Card >
                            <Card.Img variant="top" src={p.image} />
                            <Card.Body>
                                <Card.Title>{p.name}</Card.Title>
                                <Card.Text>
                                    {p.price} VND
                                </Card.Text>
                                <Button variant="primary">Details</Button>
                                <Button variant="primary">Order</Button>
                            </Card.Body>
                        </Card>
                    </Col>)}
                </Row>
                <div className="mt-2 mb-2 text-center">
                    <Button onClick = {loadMore} variant="primary">Xem them...</Button>
                </div>
            </>}

        </>
    );
}

export default Home;