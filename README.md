# Reelo QA Automation Assessment

This repository contains automation scripts for the Reelo QA assessment.

## Project Setup

Follow these steps to set up the project locally:

### 1. Clone the Repository
```bash
git clone https://github.com/Ganeshbhoge7028/Reelo-QA-Automation-Assessment.git
cd Reelo-QA-Automation-Assessment
```

### 2. Pull the Latest Changes
```bash
git pull origin main
```

### 3. Configure Your Details
Update the **config.properties** file with your credentials:

```
url=https://dev.reelo.io/
username=Bhoge Ganesh
email=your email@yopmail.com
password=YourPassword
phone=7428723247
campaignTitle=Automation Campaign
smsMessage=Hello from Ganesh Bhoge!
loginusername=youremail@gmail.com
loginpassword=YourPassword
```

> **Note:** Replace the above credentials with your actual details before running the automation.

### 4. Run the Tests
Use your preferred IDE (IntelliJ/Eclipse) or Maven:
```bash
mvn clean test
```

---

## Git Workflow

### To Commit and Push Changes
```bash
git add .
git commit -m "Your commit message"
git push origin main
```

### To Pull Latest Changes
```bash
git pull origin main
```
