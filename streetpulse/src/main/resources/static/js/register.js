document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("registerForm");

    if (!form) {
        console.error("Register form not found");
        return;
    }

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const role = document.getElementById("role").value;

        const user = { name, email, password, role };

        try {
            const res = await fetch("/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            if (res.ok) {
                alert("Registration successful!");
                window.location.href = "/login.html";
            } else {
                alert("Email already exists or registration failed");
            }

        } catch (err) {
            console.error("Error:", err);
            alert("Server error");
        }
    });
});
