<div class="concursos view">
<h2><?php echo __('Concurso'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($concurso['Concurso']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Data Aprovacao'); ?></dt>
		<dd>
			<?php echo h($concurso['Concurso']['data_aprovacao']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Data Registo'); ?></dt>
		<dd>
			<?php echo h($concurso['Concurso']['data_registo']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($concurso['Concurso']['nome']); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Concurso'), array('action' => 'edit', $concurso['Concurso']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Concurso'), array('action' => 'delete', $concurso['Concurso']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $concurso['Concurso']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('action' => 'add')); ?> </li>
	</ul>
</div>
