package my.study.portfolio.domain

import kotlinx.coroutines.flow.Flow
import my.study.portfolio.core.UseCase
import my.study.portfolio.data.model.Repo
import my.study.portfolio.data.repositories.RepoRepository

class ListUserRepositoriesUseCase(private val repository: RepoRepository) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}