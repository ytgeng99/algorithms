import random

def coin_toss(num):
    heads = 0
    tails = 0
    print 'Starting the program...'
    for i in range(1, num+1):
        if round(random.random()) == 0:
            side = 'head'
            heads += 1
        else:
            side = 'tail'
            tails += 1
        print 'Attempt #' + str(i) + ': Throwing a coin... It\'s a ' + side + '! ... Got ' + str(heads) + ' head(s) so far and ' + str(tails) + ' tail(s) so far'
    print 'Ending the program, thank you!'

coin_toss(5000)