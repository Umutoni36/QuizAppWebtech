<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #timer-container {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
        }
        #time-text {
            display: block;
        }

        #time-line-container {
            width: 100%;
            height: 20px; /* Example height */
            background-color: #ccc;
            position: relative;
        }


        .progress-container {
            width: 300px; /* Adjust width as needed */
            height: 20px;
            background-color: #ddd; /* Set background color for the container */
            border-radius: 5px; /* Add rounded corners */
        }

        .progress-bar {
            height: 100%;
            background-color: #007bff; /* Set background color for the progress bar */
            transition: width 1s ease-in-out; /* Add smooth transition for width changes */
        }

        #display-value {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* Center the text within the container */
        }

    </style>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <div id="timer-container" style="">
                <span id="time-text" style="font-family: Bahnschrift">Time Remaining: <span id="time"></span></span>
                <span id="display"  style="font-size: 15px; font-family: Bahnschrift"></span>

            </div>
            <h5 class="card-title text-center">Quiz</h5>
        </div>

        <div class="card-body">
            <form action="/question" method="post" id="quizForm">


                <c:forEach var="question" items="${question_list}" varStatus="loop">
                    <c:if test="${loop.index eq currentQuestionIndex}">
                        <div class="mb-3">
                            <label for="question" class="form-label">Question ${loop.index + 1}/${question_list.size()}</label>
                            <p id="question">${question.question_name}</p>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" class="form-check-input" id="option1" name="answer" value="${question.answer_option1}" required>
                            <label class="form-check-label" for="option1">${question.answer_option1}</label>
                        </div>
                        <div class="mb-3 form-check">
                            <input type="radio" class="form-check-input" id="option2" name="answer" value="${question.answer_option2}" required>
                            <label class="form-check-label" for="option2">${question.answer_option2}</label>
                        </div>
                        <input type="hidden" name="corectanswer" value="${question.correct_option}">
                    </c:if>
                </c:forEach>

                <input type="hidden" name="quizId" value="${quizId}">
                <input type="hidden" name="currentQuestionIndex" value="${currentQuestionIndex}">
                <input type="hidden" id="quizduration" name="quizduration" value="${quizduaration}">
                <input type="hidden" id="totalQuestions" name="totalQuestions" value="${question_list.size()}">
                <c:if test="${currentQuestionIndex < question_list.size() - 1}">
                    <button type="submit"  name="action" value="next" class="btn btn-success">Next Question</button>
                </c:if>
                <c:if test="${currentQuestionIndex == question_list.size() - 1}">
                    <button type="submit" name="action" value="complete" class="btn btn-primary">Complete Quiz</button>
                </c:if>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional, if you need JS functionality) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    const quizDurationMinutes = parseInt(document.getElementById('quizduration').value);
    const numberofquestion = parseInt(document.getElementById('totalQuestions').value);
    const timeperquestion = quizDurationMinutes / numberofquestion;
    const quizDurationSeconds = timeperquestion * 60;
    let timeLeft = quizDurationSeconds;
    let timerInterval;
    let minutes_data;
    let seconds_data;

    function updateTime() {
        minutes_data= Math.floor(timeLeft / 60);
        seconds_data = timeLeft % 60;
        document.getElementById('time').textContent = minutes_data+":"+seconds_data;
    }
    function startQuiz() {
        timerInterval = setInterval(function () {
            timeLeft--;
            updateTime();
            if (timeLeft <= 0) {
                clearInterval(timerInterval);
                endQuiz();
            }
        }, 1000);


    }


    function endQuiz() {
        document.getElementById('quizForm').querySelectorAll('input[type="radio"]').forEach(function (radio) {
            radio.disabled = true;
        });
         document.getElementById('display').textContent = "Time's up! Go to Next Question";
    }

    window.onload = function () {
        startQuiz();
        updateTime();

    }

    let tabSwitchDetected = false;
    window.addEventListener("blur", function() {
        tabSwitchDetected = true;
    });

    window.addEventListener("focus", function() {
        if (tabSwitchDetected) {
            window.location.href = "/QuizRestriction";
        }
    });

</script>

</body>
</html>
