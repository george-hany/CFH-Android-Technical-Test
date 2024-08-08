package com.app.app.ui.main.termsAndConditions

import androidx.lifecycle.MutableLiveData
import com.core.base.BaseViewModel
import com.core.data.repos.HomeRepo
import com.core.data.repos.TermsAndConditionsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TermsAndConditionsViewModel
@Inject
constructor(repo: TermsAndConditionsRepo) : BaseViewModel<TermsAndConditionsRepo>(repo) {
    val termsAndConditionsText = MutableLiveData(
        "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Terms and Conditions</title>\n" +
                "    <style>\n" +
                "        body { font-family: Arial, sans-serif; line-height: 1.6; }\n" +
                "        h1, h2, h3 { color: #333; }\n" +
                "        p { margin: 10px 0; }\n" +
                "        ul { margin: 10px 0; padding-left: 20px; }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Terms and Conditions</h1>\n" +
                "    <p>Welcome to CFH!</p>\n" +
                "    <p>These terms and conditions outline the rules and regulations for the use of CFH's App.</p>\n" +
                "    <h2>1. Acceptance of Terms</h2>\n" +
                "    <p>By accessing this app, we assume you accept these terms and conditions. Do not continue to use CFH if you do not agree to all of the terms and conditions stated on this page.</p>\n" +
                "    <h2>2. License</h2>\n" +
                "    <p>Unless otherwise stated, CFH and/or its licensors own the intellectual property rights for all material on CFH. All intellectual property rights are reserved. You may access this from CFH for your own personal use subjected to restrictions set in these terms and conditions.</p>\n" +
                "    <h2>3. User Responsibilities</h2>\n" +
                "    <p>As a user of this app, you agree to:</p>\n" +
                "    <ul>\n" +
                "        <li>Provide accurate and up-to-date information.</li>\n" +
                "        <li>Use the app in compliance with all applicable laws and regulations.</li>\n" +
                "        <li>Not engage in any activity that disrupts or interferes with the app's functionality.</li>\n" +
                "    </ul>\n" +
                "    <h2>4. Limitation of Liability</h2>\n" +
                "    <p>CFH will not be held liable for any damages arising out of or in connection with your use of the app. This includes, but is not limited to, direct, indirect, incidental, punitive, and consequential damages.</p>\n" +
                "    <h2>5. Changes to Terms</h2>\n" +
                "    <p>CFH reserves the right to revise these terms and conditions at any time. By using this app, you are expected to review these terms regularly to ensure you understand all terms and conditions governing use of this app.</p>\n" +
                "    <h2>6. Governing Law</h2>\n" +
                "    <p>These terms and conditions are governed by and construed in accordance with the laws of [Your Country], and you irrevocably submit to the exclusive jurisdiction of the courts in that State or location.</p>\n" +
                "    <p>If you have any questions about these Terms, please contact us at support@cfh.com.</p>\n" +
                "</body>\n" +
                "</html>\n"
    )
}
