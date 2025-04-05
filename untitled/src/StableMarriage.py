

# Initialization
Men = ['Victor', 'Wyatt', 'Xavier', 'Yancey','Zeus']
Women = ['Amy', 'Bertha', 'Clare', 'Diane','Erika']

# Preferences
Men_Pref = {  # indicates the preferences of the men
    'Victor':   ['Amy', 'Bertha', 'Clare', 'Diane','Erika'],
    'Wyatt': ['Bertha', 'Clare', 'Diane', 'Amy','Erika'],
    'Xavier':  ['Clare', 'Diane', 'Amy', 'Bertha','Erika'],
    'Yancey':  ['Diane', 'Amy', 'Bertha', 'Clare','Erika'],
    'Zeus':  ['Amy', 'Bertha', 'Clare', 'Diane','Erika']
}

Women_Pref = {  # indicates the preferences of the women
    'Amy':  ['Wyatt', 'Xavier', 'Yancey', 'Zeus','Victor'],
    'Bertha':   ['Xavier', 'Yancey', 'Zeus', 'Victor','Wyatt'],
    'Clare': ['Yancey', 'Zeus', 'Victor', 'Wyatt','Xavier'],
    'Dianne':  ['Zeus', 'Victor', 'Wyatt', 'Xavier','Yancey'],
    'Erika': ['Victor', 'Wyatt', 'Xavier', 'Yancey','Zeus']
}
def main():
    Men_Free = list(Men)
    Women_Free = list(Women)

    # Part 3: Proposal
    Matches = {
        'Victor':  '',
        'Wyatt': '',
        'Xavier': '',
        'Yancey': '',
        'Zeus':''
        }
    key_list = list(Matches.keys())

    # the algorithm
    iteration = 0;
    while len(Men_Free) > 0:
        for man in key_list:
            print("-----Iteration ---- " ,iteration)
            iteration = iteration +1
            for woman in Men_Pref[man]:
                if woman not in list(Matches.values()):
                    Matches[man] = woman
                    Men_Free.remove(man)
                    print('{} is no longer a free man and is tentatively engaged to {} !'.format(man, woman))
                    break
                elif woman in list(Matches.values()):
                    current_suitor = list(Matches.keys())[list(Matches.values()).index(woman)]
                    w_list = Women_Pref.get(woman)
                    if w_list.index(man) < w_list.index(current_suitor):
                        Matches[man] = woman
                        print("men free->" , Men_Free)
                        print("man->>",man)
                        print("Current Sit -->",current_suitor)
                        Men_Free.remove(man)
                        Matches[current_suitor] = ''
                        Men_Free.append(current_suitor)
                        print('{} was earlier engaged to {} but now is engaged to {}! '.format(woman, current_suitor, man))
                        Men_Free.append(current_suitor)

    print('\n ')
    print('Stable Matching Finished ! Happy engagement !')
    for man in Matches.keys():
        print('{} is engaged to {} !'.format(man, Matches[man]))


if __name__ == "__main__":
    main()