# Reelo Automation Campaign – Selenium Java Project

## Overview
This project automates the end-to-end workflow of creating and sending a campaign through the Reelo platform using **Selenium, TestNG, and Java**.  
It includes:
- Login
- Campaign Creation
- Adding Image/Logo
- Sending SMS  

---

## Prerequisites
- **Java 8+**
- **Maven**
- **TestNG**
- **Chrome Browser & ChromeDriver**  
  (Ensure compatible versions are installed)

---

## Project Setup

### 1. Clone or Download the Project
```bash
git clone <your-repo-url>
```

### 2. Update Configuration
Edit the `config.properties` file located in the project root:

```properties
url=https://dev.reelo.io/
username=Your Name
email=youremail@example.com
password=YourPassword123
phone=9999999999
campaignTitle=Automation Campaign
smsMessage=Hello from Your Name!
loginusername=youremail@example.com
loginpassword=YourPassword123
filePath=C:\Users\YourName\Downloads\LogoImage.png
SMSMassage=Hello, this is from Your Name
```

> **Note**: Replace all sample values with your own test credentials.

---

## How to Run

1. Open the project in IntelliJ or Eclipse.
2. Locate `testng.xml`.
3. Right-click → **Run 'testng.xml'**.

---

## Features
- Login to Reelo
- Campaign creation with:
  - Title
  - Logo/Image upload
  - SMS message
- End-to-end flow automation

---

## Contact
For any queries, please contact:  
`youremail@example.com`
