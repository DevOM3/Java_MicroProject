const imageArray = [
    "https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone.png?alt=media&token=af3a0a57-8712-459d-9f74-8812d3190f5e",
    "https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper.png?alt=media&token=85504b82-656a-46b8-8537-dc2acf343407",
    "https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor.png?alt=media&token=81b7c7e1-0fd4-4fb5-9753-6ab1e68fef7c"
];
const optionArray = [
    "Stone",
    "Paper",
    "Scissor",
]
let aiWins = 0;
let match = 1;
const handleButtonClick = (event) => {
    const index = Math.floor(Math.random() * imageArray.length);
    const image = imageArray[index];
    document.getElementById("ai-response").src = image;

    const aiOutput = optionArray[index];
    const userInput = event.dataset.option;

    if (aiOutput === userInput) {
        alert("Match drawn!");
    } else if (aiOutput === optionArray[0] && userInput === optionArray[1]) {
        document.getElementById("match-" + match).innerText = "You";
        match++;
    } else if (aiOutput === optionArray[0] && userInput === optionArray[2]) {
        document.getElementById("match-" + match).innerText = "AI";
        aiWins++;
        match++;
    } else if (aiOutput === optionArray[1] && userInput === optionArray[0]) {
        document.getElementById("match-" + match).innerText = "AI";
        aiWins++;
        match++;
    } else if (aiOutput === optionArray[1] && userInput === optionArray[2]) {
        document.getElementById("match-" + match).innerText = "You";
        match++;
    } else if (aiOutput === optionArray[2] && userInput === optionArray[0]) {
        document.getElementById("match-" + match).innerText = "You";
        match++;
    } else if (aiOutput === optionArray[2] && userInput === optionArray[1]) {
        document.getElementById("match-" + match).innerText = "AI";
        aiWins++;
        match++;
    }

    if (match > 3) {
        const winner = aiWins >= 2 ? "You lost" : "Congratulations, You won!!!";
        const alertString = "Round over!!\n\n" + winner + "\n\nCreating next round for you xD";
        alert(alertString);
        window.location.reload();
    }
}