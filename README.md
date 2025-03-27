# SYSC5807X-Seminar-Jenkins-Demo
A repository to perform Jenkins Test for SYSC5807X Seminar.

## ▶️ How to Run the Test in Jenkins

### 🛠 Prerequisites
- Jenkins installed and running locally (http://localhost:8080)
- Maven installed and configured in `PATH`
- BrowserStack credentials set in Jenkins
- GitHub repository connected in your Jenkins job

---

### 🚀 Run the Test (Step-by-Step)

1. Go to your Jenkins dashboard.
2. Select the job linked to this repository.
3. Click **Build Now**.
4. Wait for the pipeline to execute:
   - It will fetch the code from GitHub.
   - Use Maven to run the Selenium test.
   - Connect to BrowserStack to run on Chrome (Windows 10).
5. Click on:
   - **Console Output** to see test logs
   - **Test Result** to view pass/fail
   - **BrowserStack Report** for device/session details

---

🎯 This test opens [google.com](https://www.google.com) in a real browser on BrowserStack and prints the page title to confirm it's working.
