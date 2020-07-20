package ru.st.office.mapper

interface BiDirectMapper<SOURCE, TARGET>: Mapper<SOURCE, TARGET>, RevertMapper<SOURCE, TARGET> {
}