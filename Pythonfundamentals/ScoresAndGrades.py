import random

def randomScores():
    print 'Scores and Grades'
    for i in range(0, 10):
        score = random.randint(60, 100)
        if score < 70:
            grade = 'D'
        elif score < 80:
            grade = 'C'
        elif score < 90:
            grade = 'B'
        else:
            grade = 'A'
        print 'Score: ' + str(score) + '; Your grade is ' + grade
    print 'End of the program. Bye!'

randomScores()