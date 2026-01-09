function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const msg = document.getElementById("msg");

    fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    })
        .then(res => res.json())
        .then(user => {
            if (!user) {
                msg.innerText = "Invalid email or password";
                return;
            }

            // save user
            localStorage.setItem("user", JSON.stringify(user));

            // go to dashboard
            window.location.href = "dashboard.html";
        })
        .catch(() => {
            msg.innerText = "Server error. Try again later.";
        });
}
function logout() {
    localStorage.removeItem("user");   // remove login data
    window.location.href = "login.html";  // go back to login
}
function register() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;
    const msg = document.getElementById("msg");

    fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email, password, role })
    })
        .then(res => res.json())
        .then(user => {
            if (!user) {
                msg.innerText = "Email already exists!";
                return;
            }
            alert("Registration successful! Please login.");
            window.location.href = "login.html";
        })
        .catch(() => {
            msg.innerText = "Registration failed.";
        });
}
function uploadImage() {
    const cid = document.getElementById("imgComplaintId").value;
    const file = document.getElementById("imgFile").files[0];
    const msg = document.getElementById("imgMsg");

    if (!cid || !file) {
        msg.innerText = "Please select complaint ID and image.";
        return;
    }

    let formData = new FormData();
    formData.append("file", file);

    fetch(`http://localhost:8080/complaints/${cid}/image`, {
        method: "POST",
        body: formData
    })
        .then(res => res.text())
        .then(text => {
            msg.innerText = text;
        })
        .catch(() => {
            msg.innerText = "Upload failed.";
        });
}
