import smtplib
from email.message import EmailMessage
import os

sender = "your_email@gmail.com"
receiver = "receiver_email@gmail.com"

# 🔐 Read password from environment variable
password = os.environ.get("EMAIL_APP_PASSWORD")

msg = EmailMessage()
msg["Subject"] = "CI Reports"
msg["From"] = sender
msg["To"] = receiver
msg.set_content("Attached are the CI reports.")

files = [
    "reports/checkstyle.txt",
    "reports/TEST-app.StudentIntegrationTest.txt"
]

for file in files:
    if os.path.exists(file):
        with open(file, "rb") as f:
            msg.add_attachment(
                f.read(),
                maintype="application",
                subtype="octet-stream",
                filename=os.path.basename(file)
            )

with smtplib.SMTP("smtp.gmail.com", 587) as server:
    server.starttls()
    server.login(sender, password)
    server.send_message(msg)

print("Email sent!")