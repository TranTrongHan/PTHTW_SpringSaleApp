function deleteProduct(endpoint) {
    if (confirm("Ban chac chan muon xoa") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                location.reload();
            } else {
                alert("He thong co loi!");
            }
        });
    }
}
