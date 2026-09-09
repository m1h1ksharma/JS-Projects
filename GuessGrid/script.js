const quizData = [
  {
    question: "What does '===' mean in JavaScript?",
    options: ["Assignment", "Equality", "Strict Equality", "Comparison"],
    correct: 2
  },
  {
    question: "Which company developed JavaScript?",
    options: ["Netscape", "Google", "Microsoft", "Apple"],
    correct: 0
  }
];

let currentQuestion = 0;
let score = 0;

function loadQuestion() {
  const q = quizData[currentQuestion];
  document.getElementById("question").textContent = q.question;

  const optionsDiv = document.getElementById("options");
  optionsDiv.innerHTML = ""; // clear old buttons

  q.options.forEach((opt, index) => {
    const btn = document.createElement("button");
    btn.textContent = opt;
    btn.onclick = () => checkAnswer(index);
    optionsDiv.appendChild(btn);
  });
}

function checkAnswer(selected) {
  const correct = quizData[currentQuestion].correct;
  const result = document.getElementById("result");

  if (selected === correct) {
    score++;
    result.textContent = "✅ Correct!";
  } else {
    result.textContent = "❌ Wrong!";
  }

  currentQuestion++;

  if (currentQuestion < quizData.length) {
    setTimeout(() => {
      result.textContent = "";
      loadQuestion();
    }, 1000);
  } else {
    document.getElementById("quiz-container").innerHTML =
      `<h2>Quiz Over!</h2><p>Your Score: ${score}/${quizData.length}</p>`;
  }
}

loadQuestion();
