require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Давай поиграем в игру "Быки и коровы". <p>Правила следующие: тебе надо написать число из 4 цифр.</p> <p>Если ты угадаешь цифру и позицию, то ты оплучишь корову.</p> <p>В идеале ты должен получить 4 коровы.</p>
        a: Напиши число из 4 букв.

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