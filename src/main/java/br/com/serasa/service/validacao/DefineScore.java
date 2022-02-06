package br.com.serasa.service.validacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.serasa.service.IDefineScore;
import br.com.serasa.service.IScoreStrategy;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DefineScore implements IDefineScore {
		private final List<IScoreStrategy> listScoreStrategy;	
		@Override
		public String executar(int score) {			 
			for(IScoreStrategy iscoreStrategy : this.listScoreStrategy) {
				final String descricao = iscoreStrategy.defineDescricao(score);
				if(descricao != null) {
					return descricao;
				}
			}
			return "Score não encontrado";
		}
}
