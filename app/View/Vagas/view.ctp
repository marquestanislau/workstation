<div class="vagas view">
<h2><?php echo __('Vaga'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($vaga['Vaga']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Designacao'); ?></dt>
		<dd>
			<?php echo h($vaga['Vaga']['designacao']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Concurso'); ?></dt>
		<dd>
			<?php echo $this->Html->link($vaga['Concurso']['id'], array('controller' => 'concursos', 'action' => 'view', $vaga['Concurso']['id'])); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Carreira'); ?></dt>
		<dd>
			<?php echo $this->Html->link($vaga['Carreira']['id'], array('controller' => 'carreiras', 'action' => 'view', $vaga['Carreira']['id'])); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Vaga'), array('action' => 'edit', $vaga['Vaga']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Vaga'), array('action' => 'delete', $vaga['Vaga']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $vaga['Vaga']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Vagas'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Vaga'), array('action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('controller' => 'concursos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('controller' => 'concursos', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
	</ul>
</div>
