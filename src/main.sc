require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: patterns.sc
theme: /

    state: Start
        # Задуманное ботом число - 3219
        q!: $regex</start>
        a: Привет! Давай поиграем в игру "Быки и коровы". Правила следующие: тебе надо написать число из 4 цифр, чтобы попытаться угадать с задуманным мною. Угаданная цифра, находящаяся в той же позиции, что и задуманная мною, даст тебе быка. Угаданная цифра, находящаяся на иной относительно моего числа позиции даст тебе корову. В идеале ты должен получить 4 коровы.
        a: Не спрашивай, откуда такое название игры, это не моя идея и даже не идея Влада. Напиши число из 4 цифр, цифры не должны повторяться. **Цифры разделяй пробелами. Можешь писать что угодно до и после цифр, главное, между ними должны быть только пробелы**.
        
        state: SameNums
            # Игрок ввёл одинаковые цифры
            q!: * ($sameNums) *
            random:
                a: Да ты шутник! Ты реально думал, что я загадаю число из одинаковых цифр?
                a: Я, конечно, может, и не очень умный, но не настолько, чтобы загадать четыре одинаковой цифры.
                a: Лол. Я знаю больше одной цифры! Меня же два дня делали))
                a: Смешно)) Но моя фантазия выходит за рамки одной цифры.    
        
        
        state: NullBullyNullCow
            # Ничего не угадано
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            random:
                a: Опа, не угадал)) В твоём числе 0 коров и 0 быков. Пока из тебя не получается хороший пастух. Повтори попытку!
                a: Ни одного совпадения! Теперь ты официально "Победитель по жизни".
                a: Ты не угадал ни одну цифру. А ведь так много было надежд, наверное?))
                a: Ни одной цифры не угадал, даже близко. Надеюсь, ты понимаешь, что об этом лучше никому не знать))
        
        state: OneBullyNullCow_first_Num
            # Угадано первое число на своём месте
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            random:
                a: Ты угадал первое число. Действительно, первое число - 3. У тебя два варианта: запороть всё, только начав, или угадать же это несчастное число!
                a: Первое число ты, конечно, же угадал (3), а вот по другим ты пролетел. Надеюсь, ты не горе-пилот и не улетишь за горизонт, ошибаясь раз за разом))
            
        state: OneBullyNullCow_second_Num
            # Угадано второе число на своём месте
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            random:
                a: Батюшки! Угадал второе число! Это - 2. До успешного успеха тебе ещё далеко, так что думай, как теперь выбраться из этой ситуации))
                a: Ты угадал второе число, это 2, тут ты молодец. Но ты, наверное, не забыл, что тебе надо отгадать ещё три. Подумай о том, кем ты будешь себя считать, если сейчас забьёшь на это дело.
            
        state: OneBullyNullCow_third_Num
            # Угадано третье число на своём месте
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($thirdNumAlRight) ($unNecessaryNum) *
            random:
                a: Угадана третья цифра, и это - 1! Прям жжошь! Лучше пожги с остальными тремя, а то как-то не серьёзно))
                a: Ты угадал третью цифру (1). Остальные три цифры даже близко не пахнут. А нужно, чтоб пахли))
            
            
        state: OneBullyNullCow_fourth_Num
            # Угадано четвёртое число на своём месте
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            random:
                a: Угадано четвёртое число, 9! Я так понимаю, любишь начинать с конца? Интересно, но продолжай, до завершения ещё далеко.
                a: Ты угадал последнюю цифру (9), остальные не угадал. А я думал, что ты знаешь, что такое удача.
            
        state: TwoBullyNullCow_first_second_Num
            # Угаданы первое и второе числа на своих местах
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            a: Ты угадал первые два числа: 32ХХ. Тут ты, конечно, молодец, а остальные числа чем тебя обядели?)
            
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
            # Угаданы первое, третье и четвёртое числа на своих местах
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Угадал первое, третье и четвёртое числа: 3Х19. Конечно, можешь похвастаться об этом своему ближайшему окружению, но вот зададут вполне справедливый вопрос: а чё не четыре?
            
        state: ThreeBullyNullCow_234Num
            # Угаданы второе, третье и четвёртое числа на своих местах
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Ты угадал три цифры, стоящие на своих местах: Х219! Мгновенные победы явно не твоё))
            
        state: OneBullyOneCow_first_Num
            # Угадано первое число на месте и одно не на месте
            q!: * ($firstNumAlRight) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            a: Первая цифра верна, это 3. Также ты угадал одну из других цифр, но она стоит не на своём месте. Так что, если ты думаешь, что сейчас мог бы закончить, то глубочайше ошибаешься))
            
        state: OneBullyOneCow_second_Num
            # Угадано второе число на месте и одно не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($secondNumAlRight) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            a: Ты угадал вторую цифру, 2. Ещё ты написал другую цифру, состоящую в загаданном числе, только с местом ошибся. Не местом в жизни, а местом цифры в числе!
        
        state: OneBullyOneCow_third_Num
            # Угадано третье число на месте и одно не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($thirdNumAlRight) ($4_slotCorrectNumFromOthPlace) *
            a: Угадал третью цифру (1). Угадал ещё одну, но не угадал с местом. Вот уж не знаю, чем это тебе поможет, но мне просто жалко твоего времени, поэтому, чтобы ты его потратил меньше, я и сказал про это.  
        
        state: OneBullyOneCow_fourth_Num
            # Угадано четвёртое число на месте и одно не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($fourthNumAlRight) *
            a: Ты угадал четвёртую цифру. Вместе с ней подъехала ещё одна, правда ты не угадал с её местоположением. А ведь всё так хорошо начиналось((
                
        state: OneBullyTwoCow_first_Num
            # Угадано первое число на месте и два не на месте
            q!: * ($firstNumAlRight) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($firstNumAlRight) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            a: Первую цифру угадал: 3. И ещё две угадал, но вот стоят не на своих местах. Всё вокруг да около!
            
        state: OneBullyTwoCow_second_Num
            # Угадано второе число на месте и два не на месте
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($secondNumAlRight) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($secondNumAlRight) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            a: Угадал вторую цифру (2) и ещё две цифры, стоящие не на своих местах. Уж очень надеюсь, вы там не на деньги играете.
            
        state: OneBullyTwoCow_third_Num
            # Угадано третье число на месте и два не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($thirdNumAlRight) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($thirdNumAlRight) ($4_slotCorrectNumFromOthPlace) *
            a: Угадал третью цифру: 1. Кстати говоря, ты угадал ещё две, но какой в этом толк, если эти цифры не на своих местах? Так что ты официально ещё не отделался от этой загадки и продолжаешь её решать.
        
        state: OneBullyTwoCow_fourth_Num
            # Угадано четвёртое число на месте и два не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($fourthNumAlRight) *
            a: Ты угадал последнюю цифру (9) и ещё две цифры, только они не на своих местах. Не всё в этой жизни происходит так, как ты хочешь, не так ли?))
            
        state: OneBullyThreeCow_first_Num
            # Угадано первое число на месте и три не на месте
            q!: * ($firstNumAlRight) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace)
            a: Ты угадал первое число (3) и все остальные числа. Только вот остальные числа стоят не на своих местах. Бота для игры добавил, везение не добавил))
            
        state: OneBullyThreeCow_second_Num
            # Угадано второе число на месте и три не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($secondNumAlRight) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace) *
            a: Оп, угадал все цифры! Только вот только вторая на месте (2). А остальные нет, не на своих местах. Но мы же всегда найдём оправдание этому и скажем, что "я не знал" и тому подобное))
            
        state: OneBullyThreeCow_third_Num
            # Угадано третье число на месте и три не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($thirdNumAlRight) ($4_slotCorrectNumFromOthPlace) *
            a: Третью цифру угадал (1). И остальные цифры угадал, а их место в числе не угадал. Вот уж надеюсь, ты не на деньги играешь, потому что сейчас ты бы мог конкретно проиграть))
            
        state: OneBullyThreeCow_fourth_Num
            # Угадано четвёртое число на месте и три не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($fourthNumAlRight) *
            a: Ты угадал последнюю цифру, которая на месте (9) и остальные цифры, которые не на своём месте. Ты знаешь, из каких цифр сформирован конечный ответ, поэтому поменяй их порядок. А если не поменяешь, то боюсь, совесть не позволит тебе уснуть сегодня ночью))
            
        state: TwoBullyOneCow_first_second_Num
            # Угадано первое и второе числа на месте одно не на месте
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            a: Ты угадал первую и вторую цифры: 21ХХ. В направленном тобою числе также есть одна из цифр, которую ты угадал, но она стоит не на своём месте. Нельзя просто так взять и всё угадать сразу, верно?))
            
        state: TwoBullyOneCow_first_fourth_Num
            # Угадано первое и четвёртое числа на месте и одно не на месте
            q!: * ($firstNumAlRight) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($fourthNumAlRight) *
            a: Ты угадал первую и четвёртую цифры: 3ХХ9. Также ты угадал ещё одну цифру, но вот не на своём месте только она стоит. А ведь мог бы угадать всё сразу и не растрачивать рабочее время, за которое тебе платят))
            
        state: TwoBullyOneCow_second_third_Num
            # Угадано второе и третье числа на месте и одно не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($secondNumAlRight) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($thirdNumAlRight) ($4_slotCorrectNumFromOthPlace) *
            a: Ты угадал вторую и третью цифры: Х21Х. Ещё одна цифра стоит не на своём месте, поэтому продолжай угадывать. Не переживай, никто не идеален, в том числе и везение))
            
        state: TwoBullyOneCow_first_third_Num
            # Угадано первое и третье числа на месте и одно не на месте
            q!: * ($firstNumAlRight) ($2_slotCorrectNumFromOthPlace) ($thirdNumAlRight) ($unNecessaryNum) *
            q!: * ($firstNumAlRight) ($unNecessaryNum) ($thirdNumAlRight) ($4_slotCorrectNumFromOthPlace) *
            a: Ты угадал первую и третью цифры: 3Х1Х. Ещё одна из цифр тоже угадана, но стоит не на своём месте, поэтому ты не закончил. В камень-ножницы-бумага ты также играешь?))
            
        state: TwoBullyOneCow_third_fourth_Num
            # Угадано третье и четвёртое числа на месте и одно не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($thirdNumAlRight) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Ты угадал третью и четвёртую цифры: ХХ19. Есть ещё одна угаданная цифра, которая стоит не на своём месте, итого ты знаешь, что итоговое число включает в себя три из  ранее написанных тобою цифр. Но не думай, что победа близка, ещё можно всё с успехом запороть))
            
        state: TwoBullyOneCow_second_fourth_Num
            # Угадано второе и четвёртое числа на месте и одно не на месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($secondNumAlRight) ($unNecessaryNum) ($fourthNumAlRight) *
            q!: * ($unNecessaryNum) ($secondNumAlRight) ($3_slotCorrectNumFromOthPlace) ($fourthNumAlRight) *
            a: Что ж, ты угадал вторую и четвёртую цифры: Х2Х9. Ещё одна цифра затесалась где-то не на своём месте, так чсто продолжай угадывать. А прикинь, если бы это была игра на выживание, и у тебя была последняя попытка?))
            
        state: TwoBullyTwoCow_first_second_Num
            # Угадано первое и второе числа и два не на месте
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($fourthNumAlRight) ($thirdNumAlRight) *
            a: Первая и вторая написанные тобою цифры стоят на своих местах, ты угадал, а вот третья и четвёртая стоят не на своих местах, поэтому продолжай угадывать. Вот уж не знаю, что тебе предложить))
            
        state: TwoBullyTwoCow_first_fourth_Num
            # Угадано первое и четвёртое числа на месте и два не на месте
            q!: * ($firstNumAlRight) ($thirdNumAlRight) ($secondNumAlRight) ($fourthNumAlRight) *
            a: Первая и последняя цифры угаданы и стоят на своих местах. Другие ты тоже угадал, но они стоят не на своих местах, поэтому продолжай игру. Вот реально интересно, сколько попыток тебе ещё понадобится?))
            
        state: TwoBullyTwoCow_second_third_Num
            # Угадано второе и третье числа на месте и два не на месте
            q!: * ($fourthNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) ($firstNumAlRight) *
            a: Вторая и третья цифры верны и стоят на своих местах, крайние цифры тоже есть в итоговом числе, но стоят не на своих местах. По статистике, для того, чтобы решить эту задачу на данном этапе одной попыткой, нужно IQ не ниже 40. Пожалуйста, не подведи, вдруг, здесь когда-нибудь появится рейтинг игроков))
        
        state: TwoBullyTwoCow_first_third_Num
            # Угадано первое и третье числа на месте и два не на месте
            q!: * ($firstNumAlRight) ($fourthNumAlRight) ($thirdNumAlRight) ($secondNumAlRight) *
            a: Ты угадал первую и третью цифры. Вторая и четвётртая цифры тоже верны, но стоят не на своих местах. Да с таким успехом тебе в шашки играть только! Продолжай угадывать))
        
        state: TwoBullyTwoCow_third_fourth_Num
            # Угадано третье и четвёртое числа на месте и два не на месте
            q!: * ($secondNumAlRight) ($firstNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            a: Ты угадал третью и четвёртую цифры. Первая и вторая также есть в итоговом числе, но ты такой везучий, что перепутал их местами, поэтому продолжай угадывать. Главное, уксус с минералкой не путай))
        
        state: TwoBullyTwoCow_second_fourth_Num
            # Угадано второе и четвёртое числа на месте и два не на месте
            q!: * ($thirdNumAlRight) ($secondNumAlRight) ($firstNumAlRight) ($fourthNumAlRight) *
            a: Ты угадал вторую и четвёртую цифры. Первая и третья перепутаны местами. Даю ещё одну попытку. Если не знаешь, как решить задачу, то, увы, Гугл тебе в этом деле не поможет))
        
        state: NullBullyOneCow
            # Угадано одно число не на своём месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            a: В написанном тобою ответе есть одна цифра, которая есть в загаданном мной числе, но она находится не на своём месте. Да, жить тебе легче от этого не сталоэ. но кто сказал, что будет легко?
        
        state: NullBullyTwoCow
            # Угадано два числа не на своём месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($unNecessaryNum) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace) *
            a: В написанном тобой ответе есть две цифры, которые есть в итоговом числе, но они стоят не на своих местах. Легко начать у тебя, я смотрю, не получилось. Ну да ладно, можешь повторить попытку.
        
        state: NullBullyThreeCow
            # Угадано три числа не на своём месте
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($unNecessaryNum) *
            q!: * ($unNecessaryNum) ($2_slotCorrectNumFromOthPlace) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($3_slotCorrectNumFromOthPlace) ($4_slotCorrectNumFromOthPlace) *
            q!: * ($1_slotCorrectNumFromOthPlace) ($2_slotCorrectNumFromOthPlace) ($unNecessaryNum) ($4_slotCorrectNumFromOthPlace) *
            random:
                a: В написанном ответе есть три цифры, из которых состоит итоговый ответ, но ты умудрился все их перепутать местами. Ты серьёзно?))
                a: Ты угадал три цифры, но каждая из них не стоит на своём месте. Четвёртую так вообще не угадал) Как же хорошо, что количество попыток ещё не ограничено, а то было бы фиаско, братан!
            
        state: NullBullyFourCow
            # Угадано три числа не на своём месте
            q!: * ($secondNumAlRight) ($firstNumAlRight) ($fourthNumAlRight) ($thirdNumAlRight) *
            q!: * ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) ($firstNumAlRight) *
            q!: * ($fourthNumAlRight) ($thirdNumAlRight) ($secondNumAlRight) ($firstNumAlRight) *
            q!: * ($thirdNumAlRight) ($fourthNumAlRight) ($secondNumAlRight) ($firstNumAlRight) *
            q!: * ($thirdNumAlRight) ($fourthNumAlRight) ($firstNumAlRight) ($secondNumAlRight) *
            q!: * ($fourthNumAlRight) ($firstNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) *
            q: * ($secondNumAlRight) ($fourthNumAlRight) ($firstNumAlRight) ($thirdNumAlRight) *
            q: * ($thirdNumAlRight) ($firstNumAlRight) ($fourthNumAlRight) ($secondNumAlRight) *
            q: * ($fourthNumAlRight) ($thirdNumAlRight) ($firstNumAlRight) ($secondNumAlRight) *
            random:
                a: Ну что ж сказать? Ты перепутал все цифры местами) Это уметь надо, так что даже ругать не буду. По утверждению моего бота-коллеги, технически ты можешь потратить до 24 попыток, угадывая нужное число. Всё зависит от того, насколько ты победитель по жизни))
                a: Все цифры угадал - поздравляю! Жаль, что они стоят не на своих местах. Так что ты не закончил, давай ещё пытайся))
        
        state: AllBullyNullCow
            # Угаданы все числа
            q!: * ($firstNumAlRight) ($secondNumAlRight) ($thirdNumAlRight) ($fourthNumAlRight) *
            q!: * ($final_answer) *
            random:
                a: Все цифры угадал! На вот тебе в качестве подарка 🍾)) Купить, правда, придётся самостоятельно.

    state: Hello
        intent!: /привет
        a: Привет привет. Напиши число из 4 символов.

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