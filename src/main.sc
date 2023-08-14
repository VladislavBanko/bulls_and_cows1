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
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            a: Опа, не угадал)) В твоём числе 0 коров и 0 быков. Пока из тебя не получается хороший пастух. Повтори попытку!
            a: Ни одного совпадения! Теперь ты официально "Победитель по жизни".
        
        state: OneBullyNullCow
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            a: Ты угадал одно из чисел и угадал с позицией, но какое это число - нискажу)))) Пытайся дальше, раз делать нечего.
            
        state: TwoBullyNullCow
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($thirdNumAlRight) ($fourthNumAlRight) *
            q!: * ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            a: А ты ничего так, два числа угадал, стоящих на своих местах)) Но этого недостаточно, угадывай дальше)
            
        state: ThreeBullyNullCow
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($thirdNumAlRight) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Ты угадал три цифры, стоящие на своих местах! Подумай, какая есть четвёртая цифра, и напиши ответ, который, полюбас, окажется неправильным!
            
        state: FourBullyNullCow
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Да ну нафиг! Все цифры угадал! Да как такое можно? Ну ладно. На вот тебе в качестве подарка 🍾)) Купить, правда, придётся самостоятельно

    state: Hello
        intent!: /привет
        a: Привет привет. Напиши число из 4 символов, и я скажу, сколько у тебя коров, а сколько быков.

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}