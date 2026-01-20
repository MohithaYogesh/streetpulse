document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("loginForm");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        const user = { email, password };

        try {
            const res = await fetch("/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            if (!res.ok) {
                const msg = await res.text();
                alert(msg);
                return;
            }

            const data = await res.json();

            // -------- ROLE BASED REDIRECT --------
            if (data.role === "ADMIN") {
                window.location.href = "/admin-dashboard.html";
            }
            else if (data.role === "VOLUNTEER") {
                window.location.href = "/volunteer-dashboard.html";
            }
            else {
                window.location.href = "/citizen-dashboard.html";
            }

        } catch (err) {
            console.error(err);
            alert("Server error");
        }
    });
});

