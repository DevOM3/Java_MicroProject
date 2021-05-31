//const time = new Date().toLocaleTimeString().toString().split(":")[1];
//const greetString = (time > 5 && time < 12) ? "Morning" : (time > 12 && time < 17) ? "Afternoon" : (time > 17 && time < 19) ? "Evening" : "Night";

var options = {
  strings: ["Hello,<br/><br/>Welcome to <b>SPS.live</b>! This is a gaming platform to play 'Stone Paper Scissor' online with our AI hosted online. This platform is available as a website as well as a standalone application for windows and both of then are powered by 'The Java Programming Language'<br/><br/>This project is developed as a final year mini project for a subject called 'Advanced Java Programming' by <br/><ul><li><b>Om Prashant Londhe (186027)</b></li><li><b>Ajay Kisan Rathod (186029)</b></li></ul><br/><br/>Technologies used are-<br/><ul><li><b>AWT</b></li><li><b>AWT Events</b></li><li><b>Swing</b></li><li><b>Java Server Programing</b></li><li><b>Servlet</b></li><li><b>JSP</b></li></ul><br/><br/>Thank you!!!"],
  typeSpeed: 40
};

var typed = new Typed('.aboutText', options);
