package my.study.portfolio.data.repositories

import kotlinx.coroutines.flow.flow
import my.study.portfolio.core.RemoteException
import my.study.portfolio.data.services.GitHubService
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService): RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possível fazer a busca no momento")
        }

    }
}