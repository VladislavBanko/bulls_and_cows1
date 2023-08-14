require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: patterns.sc
theme: /

    state: Start
        # Задуманное ботом число - 3219
        q!: $regex</start>
        a: Привет! Давай поиграем в игру "Быки и коровы". Правила следующие: тебе надо написать число из 4 цифр, чтобы попытаться угадать с задуманным мною. Угаданная цифра, находящаяся в той же позиции, что и задуманная мною, даст тебе быка. Угаданная цифра, находящаяся на иной относительно моего числа позиции даст тебе корову. В идеале ты должен получить 4 коровы.
        a: Напиши число из 4 цифр. Цифры разделяй пробелами.
        
        state: NullBullyNullCow
            # Ничего не угадано
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            a: Опа, не угадал)) В твоём числе 0 коров и 0 быков. Пока из тебя не получается хороший пастух. Повтори попытку!
            a: Ни одного совпадения! Теперь ты официально "Победитель по жизни".
        
        state: OneBullyNullCow_first_Num
            # Угадано первое число на своём месте
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            a: Ты угадал первое число. Действительно, первое число - 3. Но что же по остальным? Пытайся, вдруг чё дельное получится!
            
        state: OneBullyNullCow_second_Num
            # Угадано второе число на своём месте
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            a: Батюшки! Угадал второе число! Это - 2. Но до успешного успеха тебе ещё далеко!
            
        state: OneBullyNullCow_third_Num
            # Угадано третье число на своём месте
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($thirdNumAlRight) ($unNecessaryNum) *
            a: Угадано третье число, и это действительно 1! Прям жжошь! Но мне этого недостаточно! Отгадай остальные три!
            
        state: OneBullyNullCow_fourth_Num
            # Угадано четвёртое число на своём месте
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            a: Угадано четвёртое число, 9! Я так понимаю, любишь начинать с конца? Интересно, но продолжай, до завершения ещё далеко.
            
        state: TwoBullyNullCow_first_second_Num
            # Угаданы первое и второе числа на своих местах
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            a: Ты угадал первые два числа: 32ХХ. Ну давай, удиви по остальным!
            
        state: TwoBullyNullCow_first_fourth_Num
            # Угаданы первое и четвёртое числа на своих местах
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            a: Ты угадал первое и последнее числа: 3ХХ9. Начало и конец. Середину, я так понимаю, ты не любишь))
            
        state: TwoBullyNullCow_second_third_Num
            # Угаданы второе и третье числа на своих местах
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($thirdNumAlRight) ($unNecessaryNum) *
            a: Второе и третье угадано: Х21Х. Теперь пройдись по краям, нечего их игнорить! Ты же наверняка не любишь, когда игнорят тебя, цифры ничем не хуже, так что давай!))
            
        state: TwoBullyNullCow_first_third_Num
            # Угаданы первое и третье числа на своих местах
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($thirdNumAlRight) ($unNecessaryNum) *
            a: Ты угадал первое и третье числа: 3Х1Х. Продолжай, любитель шашечного угадывания! За тебя это никто не сделает))
            
        state: TwoBullyNullCow_third_fourth_Num
            # Угаданы третье и четвёртое числа на своих местах
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Угаданы третье и четвертое числа: ХХ19. А первые два куда делись? Уж потрудись угадать, не всё так просто, как оказалось)))
            
        state: TwoBullyNullCow_second_fourth_Num
            # Угаданы второе и четвёртое числа на своих местах
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($unNecessaryNum) ($fourthNumAlRight) *
            a: Угаданы второе и четвёртое числа: Х2Х9. Это, конечно, всё хорошо, но разве это предел твоих ожиданий в жизни? Угадай ещё два числа, и тогда ты сможешь гордиться собой и рассказывать друзьям, на что ты потратил две минуты своей жизни.
            
        state: ThreeBullyNullCow_123Num
            # Угаданы первое, второе и третье числа на своих местах
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) ($unNecessaryNum) *
            a: Ты угадал первые три числа: 321Х. Этого могло не произойти, будь ты чуточку более везучим))
            
        state: ThreeBullyNullCow_124Num
            # Угаданы первое, второе и четвёртое числа на своих местах
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($unNecessaryNum) ($fourthNumAlRight) *
            a: Ты угадал первое, второе и четвёртое числа: 32Х9. Ну что ж поделать! В Битву Экстрасенсов тебя таким точно не возьмут!
            
        state: ThreeBullyNullCow_134Num
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Угадал первое, третье и четвёртое числа: 3Х19. Конечно, можешь похвастаться об этом своему ближайшему, но вот зададут вполне справедливый вопрос: а чё не четыре?
            
        state: ThreeBullyNullCow_234Num
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Ты угадал три цифры, стоящие на своих местах: Х219! Мгновенные победы явно не твоё))
            
        state: FourBullyNullCow
            # Угаданы все числа
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Батюшки! Все цифры угадал! Да как такое можно? Ну ладно. На вот тебе в качестве подарка 🍾)) Купить, правда, придётся самостоятельно.

    state: Hello
        intent!: /привет
        a: Привет привет. Напиши число из 4 символов, и я скажу, сколько у тебя коров, а сколько быков.

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}.
        a: Напоминаю, что цифры должны быть написаны через пробел без знаков препинания между ними. А то так у тебя ничего не получится. По другим вопросам я тебе не помощник, потому что я умею играть не иначе как в "Быки и коровы". 

    state: Match
        event!: match
        a: {{$context.intent.answer}}