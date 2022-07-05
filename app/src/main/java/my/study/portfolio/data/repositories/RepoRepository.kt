package my.study.portfolio.data.repositories

import kotlinx.coroutines.flow.Flow
import my.study.portfolio.data.model.Repo

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}