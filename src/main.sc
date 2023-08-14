require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Давай поиграем в игру "Быки и коровы".
        Правила следующие: тебе надо написать число из 4 цифр.
        Если ты угадаешь цифру и позицию, то ты оплучишь корову.
        Если ты угадаешь цифру, но она будет на позиции, отличной от загаданной, то ты получишь быка.
        В идеале ты должен получить 4 коровы.
        
        Напиши число из 4 букв.
        go!: 

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}