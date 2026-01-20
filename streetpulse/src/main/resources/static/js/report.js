document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("reportForm");

    form.addEventListener("submit", async (e) => {
        e.preventDefault(); // 🔴 STOP NORMAL SUBMIT

        try {
            const title = document.getElementById("title").value;
            const description = document.getElementById("description").value;
            const address = document.getElementById("address").value;
            const priority = document.getElementById("priority").value;
            const latitude = document.getElementById("latitude").value || null;
            const longitude = document.getElementById("longitude").value || null;
            const imageFile = document.getElementById("image").files[0];

            let imageName = null;

            // ✅ 1️⃣ Upload image (if selected)
            if (imageFile) {
                const imgData = new FormData();
                imgData.append("file", imageFile);

                const imgRes = await fetch("/api/complaints/upload", {
                    method: "POST",
                    body: imgData
                });

                if (!imgRes.ok) {
                    alert("Image upload failed");
                    return;
                }

                imageName = await imgRes.text();
            }

            // ✅ 2️⃣ Submit complaint
            const complaint = {
                title,
                description,
                address,
                priority,
                latitude,
                longitude,
                image: imageName
            };
            console.log("TITLE VALUE:", title);
            const res = await fetch("/api/complaints", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(complaint)
            });

            if (!res.ok) {
                const msg = await res.text();
                alert("Failed to submit complaint: " + msg);
                return;
            }

            // ✅ SUCCESS POPUP
            alert("✅ Complaint submitted successfully!");

            form.reset();

        } catch (err) {
            console.error(err);
            alert("Server error. Please try again.");
        }
    });
});
