students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

def full_name(ls):
    for student in students:
        print student['first_name'], student['last_name']

full_name(students)

users = {
 'Students': [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
  ],
 'Instructors': [
     {'first_name' : 'Michael', 'last_name' : 'Choi'},
     {'first_name' : 'Martin', 'last_name' : 'Puryear'}
  ]
 }

def students_instructors(dict):
    for key in dict.keys():
        print key
        for i, user in enumerate(dict[key]):
            first = user['first_name'].upper()
            last = user['last_name'].upper()
            print str(i + 1) + ' - ' + first + ' ' + last + ' - ' + str(len(first + last))

students_instructors(users)