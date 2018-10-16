package ru.capjack.ktjs.common.geom

import ru.capjack.ktjs.common.Changeable

interface ChangeableAxial<T> : Axial<T>, Changeable<Axial<T>>